package com.apec.pos.controller.admin;

import com.apec.pos.enu.ErrorCode;
import com.apec.pos.enu.OrderStatus;
import com.apec.pos.response.Response;
import com.apec.pos.service.BillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ADMIN")
@SecurityRequirement(name = "bearerAuth")
public class BillAdminController {

    @Autowired
    private BillService billService;

    @Operation(summary = "lấy ra bill phía ADMIN")
    @RequestMapping(value = "get-bill",method = RequestMethod.POST)
    public ResponseEntity getBill(@RequestParam int pageIndex, @RequestParam int pageSize, @RequestParam(required = false) OrderStatus orderStatus){
        return ResponseEntity.ok(new Response(true,"", ErrorCode.SUCCESS,billService.getBill(pageIndex,pageSize,orderStatus)));
    }
}
