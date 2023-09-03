package com.apec.pos.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "user")
public class CartController {


//    @RequestMapping(value = "",method = RequestMethod.POST)
//    @Operation
//    public ResponseEntity  addToCart(){
//         return  ResponseEntity.ok(new Response(true,"",));
//    }
}
