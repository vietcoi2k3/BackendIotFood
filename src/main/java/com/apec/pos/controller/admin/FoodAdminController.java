package com.apec.pos.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.apec.pos.Dto.ToppingDTO.ToppingRequest;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    private FoodService foodService;

    @Autowired
    private ObjectMapper objectMapper;

    @Operation(summary = "thêm food", description = "dsadsadas")
    @RequestMapping(value = "add-food", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity addFood(
            @ModelAttribute AddFoodRequest addFoodRequest,BindingResult bindingResult)
    {



   return ResponseEntity.ok(new Response(true, "Thành công", ErrorCode.SUCCESS, foodService.addFood(addFoodRequest)));
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
