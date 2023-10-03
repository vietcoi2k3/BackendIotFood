package com.apec.pos.controller.admin;

import com.apec.pos.entity.VoucherEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.repository.VoucherReposioty;
import com.apec.pos.response.Response;
import com.apec.pos.service.VoucherService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping(value = "ADMIN")
public class VoucherAdminController {

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private VoucherReposioty voucherReposioty;
    @RequestMapping(value = "add-voucher",method = RequestMethod.POST)
    public ResponseEntity addVoucher(@RequestBody VoucherEntity voucherEntity){
        voucherEntity.setExpired(voucherEntity.getExpired().plusDays(1));
        return ResponseEntity.ok(new Response(true,"",voucherReposioty.insert(voucherEntity)));
    }
    @RequestMapping(value = "update-voucher",method = RequestMethod.PUT)
    public ResponseEntity updateVoucher(@RequestBody VoucherEntity voucherEntity){
        return ResponseEntity.ok(new Response(true,"",voucherReposioty.update(voucherEntity)));
    }

    @RequestMapping(value = "delete-voucher",method = RequestMethod.DELETE)
    public ResponseEntity deleteVoucher(@RequestParam Integer id){
        return ResponseEntity.ok(new Response(true,"",voucherReposioty.delete(id)));
    }

    @RequestMapping(value = "paging-voucher",method = RequestMethod.POST)
    public ResponseEntity pagingVoucher(@RequestParam Integer pageIndex,@RequestParam Integer pageSize){
        return ResponseEntity.ok(new Response<>(true,"",voucherService.pagingVoucher(pageIndex,pageSize)));
    }
}
