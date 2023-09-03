package com.apec.pos.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.apec.pos.Dto.ToppingDTO.ToppingRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.FoodDto.AddFoodRequest;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.FoodService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "ADMIN")
@CrossOrigin
@SecurityRequirement(name = "bearerAuth")
public class FoodAdminController {

    @Autowired
    FoodService foodService;

    @Operation(summary = "thêm food", description = "dsadsadas")
    @RequestMapping(value = "add-food", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity addFood(
            @ModelAttribute List<ToppingRequest> toppingRequests, @ModelAttribute AddFoodRequest addFoodRequest
    ) {
        return ResponseEntity.ok(new Response(true, "Thành công", ErrorCode.SUCCESS, foodService.addFood(addFoodRequest, toppingRequests)));
    }

    @RequestMapping(value = "update-food", method = RequestMethod.PUT, consumes = "multipart/form-data")
    @Operation(summary = "sửa món ăn", description = "")
    public ResponseEntity updateFood(@ModelAttribute AddFoodRequest addFoodRequest) {
        try {
            return ResponseEntity.ok(new Response(true, "Thành công", ErrorCode.SUCCESS, foodService.updateFood(addFoodRequest)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "update-status-food", method = RequestMethod.PUT)
    @Operation(summary = "sửa status")
    public ResponseEntity updateStatusFood(@RequestParam Integer id, @RequestParam Boolean status) {
        return ResponseEntity.ok(new Response(true, "Thành công", ErrorCode.SUCCESS, foodService.updateStatusFood(id, status)));
    }

    @Operation(summary = "phân trang sản phẩm", description = "pageIndex nhận vào tính từ 0")
    @RequestMapping(value = "/paging-food-admin", method = RequestMethod.POST)
    public ResponseEntity pagingFood(@RequestParam int pageSize, @RequestParam int pageIndex) {
        return ResponseEntity.ok(new Response(true, "trang" + pageIndex, ErrorCode.SUCCESS, foodService.paging(pageSize, pageIndex)));
    }

    @Operation(summary = "xoá nhiều sản phẩm")
    @RequestMapping(value = "/delete-food", method = RequestMethod.POST)
    public ResponseEntity multiDelete(@RequestBody Set<Integer> ids) {
        return ResponseEntity.ok(new Response(true, "", foodService.MuiltiDelete(ids)));
    }
}
