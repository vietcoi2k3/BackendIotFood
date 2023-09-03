package com.apec.pos.controller.user;

import com.apec.pos.Dto.billDTO.BillRequest;
import com.apec.pos.response.Response;
import com.apec.pos.service.BillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "user")
public class BillController {

    @Autowired
    private BillService billService;

    @Operation(summary = "Them bill")
    @RequestMapping(value = "add-bill", method = RequestMethod.POST)
    public ResponseEntity addBill(@RequestBody BillRequest billRequest) {
        return ResponseEntity.ok(new Response<>(true, "", billService.addBill(billRequest)));
    }
}
