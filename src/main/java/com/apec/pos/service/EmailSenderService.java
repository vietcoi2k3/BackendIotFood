package com.apec.pos.service;

import com.apec.pos.dto.accountDto.MailAuth;
import com.apec.pos.dto.accountDto.PassAndOtp;
import com.apec.pos.dto.otpDto.OtpMail;
import com.apec.pos.dto.otpDto.TokenAndOtp;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.repository.AccountRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class EmailSenderService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String sendEmail(String toEmail,String username){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        OtpMail otpMail = new OtpMail();
        otpMail.generateOTPandTimeEx(toEmail,username);
        simpleMailMessage.setFrom("tlufood.career@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Xác thực email");
        simpleMailMessage.setText("Mã OTP của bạn là "+otpMail.getOtp());
        httpSession.setAttribute("otpMail",otpMail);
        javaMailSender.send(simpleMailMessage);

        return "OTP đã được tạo, mời bạn check mail";
    }

    public String sendEmailByForget(String username){
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if (accountEntity==null){
            throw new RuntimeException("tài khoản này không tồn tại");
        }
        return sendEmail(accountEntity.getEmail(),username);
    }

    public String changePassword(PassAndOtp passAndOtp){
        OtpMail otpMail = (OtpMail) httpSession.getAttribute("otpMail");
        Boolean auth = (Boolean) httpSession.getAttribute("Authenticate");
        if (auth==null){
            throw new RuntimeException("CHƯA XÁC THỰC");
        }
        if (!auth){
            throw new RuntimeException("CHƯA XÁC THỰC");
        }
        AccountEntity accountEntity = accountRepository.findByUsername(otpMail.getUsername());
        accountEntity.setPassword(passwordEncoder.encode(passAndOtp.getNewPassword()));
        accountRepository.update(accountEntity);
        httpSession.removeAttribute("Authenticate");

        return "ĐỔI MẬT KHẨU THÀNH CÔNG";
    }

    public String validateOtpForVerify(String otp){
        OtpMail otpMail = (OtpMail) httpSession.getAttribute("otpMail");
        if (otpMail==null){
            throw new RuntimeException("chưa tạo otp");
        }
        if (!otpMail.authenticateOtp(otp)){
            throw new RuntimeException("otp không chính xác");
        }
        AccountEntity accountEntity = accountRepository.findByUsername(otpMail.getUsername());
        accountEntity.setEmail(otpMail.getEmail());
        accountRepository.update(accountEntity);
        httpSession.removeAttribute("otpMail");
        return "Xác thực thành công";
    }

    public String validateOtpForForgetPass(String otp){
        OtpMail otpMail = (OtpMail) httpSession.getAttribute("otpMail");
        if (otpMail==null){
            throw new RuntimeException("chưa tạo otp");
        }
        if (!otpMail.authenticateOtp(otp)){
            throw new RuntimeException("otp không chính xác");
        }
        httpSession.setAttribute("Authenticate",true);
        httpSession.removeAttribute("otpMail");
        return "XÁC THỰC THÀNH CÔNG";
    }
    public boolean isExitsEmail(String username){
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if (accountEntity==null){
            throw new RuntimeException("tài khoản không tồn tại");
        }
        if (accountEntity.getEmail()==null){
            return false;
        }
        return true;
    }


}
