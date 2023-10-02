package com.apec.pos.controller.user;

import com.apec.pos.dto.voucherDTO.VoucherRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoucherController {

    @Autowired
    private VoucherService voucherService;
    @MessageMapping("/app/use-voucher")
    @SendTo("/topic/use-voucher")
    public ResponseEntity useVoucher(@Payload VoucherRequest voucherRequest) {
        System.out.println("ddd");
        try{
            return ResponseEntity.ok(new Response<>(true,"thành công",ErrorCode.SUCCESS,voucherService.useVoucher(voucherRequest)));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(false, ex.getMessage(),ErrorCode.BAD_REQUEST));
    }
    }

    @RequestMapping(value = "paging-voucher",method = RequestMethod.POST)
    public ResponseEntity pagingVoucher(@RequestParam Integer pageIndex, @RequestParam Integer pageSize){
        return ResponseEntity.ok(new Response<>(true,"",voucherService.pagingVoucher(pageIndex,pageSize)));
    }
}
