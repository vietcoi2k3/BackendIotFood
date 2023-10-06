package com.apec.pos.controller.user;

import com.apec.pos.dto.billDTO.BillRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.response.Response;
import com.apec.pos.service.BillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "user")
public class BillController {

    @Autowired
    private BillService billService;

//    @Operation(summary = "Them bill")
//    @RequestMapping(value = "add-bill", method = RequestMethod.POST)
    @MessageMapping("/app/add-bill")
    @SendTo("/topic/add-bill")
    public ResponseEntity addBill(@RequestBody BillRequest billRequest) {
        try {
           return ResponseEntity.ok(new Response<>(true, "", billService.addBill(billRequest)));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(false,e.getMessage()));
        }
    }

    @Operation(summary = "lấy ra bill phía người dùng")
    @RequestMapping(value = "get-bill",method = RequestMethod.POST)
    public ResponseEntity getBill(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) OrderStatus orderStatus ){
        return ResponseEntity.ok(new Response(true,"", ErrorCode.SUCCESS,billService.getBillUser(pageIndex,pageSize,orderStatus)));
    }
}
