package com.apec.pos.service;

import com.apec.pos.dto.accountDto.MailAuth;
import com.apec.pos.dto.accountDto.PassAndOtp;
import com.apec.pos.dto.otpDto.OtpMail;
import com.apec.pos.dto.otpDto.TokenAndOtp;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.repository.AccountRepository;
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
@SessionAttributes("otpMail")
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String sendEmail(String toEmail,String username,HttpSession httpSession){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        OtpMail otpMail = new OtpMail();

        otpMail.generateOTPandTimeEx(toEmail);
        keyValueMap.put(username,otpMail);
        simpleMailMessage.setFrom("viet1234561231@gmail.com");

        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Xác thực email");
        simpleMailMessage.setText("Mã OTP của bạn là "+otpMail.getOtp());
        httpSession.setAttribute("otpMail",otpMail);

        javaMailSender.send(simpleMailMessage);

        return "OTP đã được tạo, mời bạn check mail";
    }

    public String sendEmailByForget(String username,HttpSession httpSession){

        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if (accountEntity==null){
            throw new RuntimeException("tài khoản này không tồn tại");
        }
        return sendEmail(accountEntity.getEmail(),username,httpSession);
    }


    public String changePassword(PassAndOtp passAndOtp,String username){
        if (!validateOtp(passAndOtp.getOtp(),username)){
            throw new RuntimeException("Đổi mật khâu thất bại");
        }
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        accountEntity.setPassword(passwordEncoder.encode(passAndOtp.getNewPassword()));
        accountRepository.update(accountEntity);
        keyValueMap.remove(username);

        return "ĐỔI MẬT KHẨU THÀNH CÔNG";
    }

    public String validateOtpForVerify(String otp,HttpSession httpSession){

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
        System.out.println("toi la viet "+5555);
        return "Xác thực thành công";
    }


    public String validateOtpForForgetPass(String otp,String username){
        if (!validateOtp(otp,username)){
            throw new RuntimeException("otp không chính xác");
        }
        OtpMail otpMail = keyValueMap.get(username);
        otpMail.generateOTPandTimeEx("");
        keyValueMap.put(username,otpMail);
        return otpMail.getOtp();

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
