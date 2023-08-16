package com.apec.pos.Unitl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(),
						description =  "\n\nTrường '<b>createDate</b>', '<b>createBy</b>', '<b>modifiedDate</b>' và '<b>modifiedBy</b>' sẽ tự động tạo khi thêm hoặc cập nhật dữ liệu.\n",
				           
				version = "1.0"
				),	
		servers= {
				@Server(
						description = "Local EVM",
						url = "http://localhost:8089"
						),
				@Server(
						description = "PROD EVM",
						url = "https://server-iot-food.onrender.com"
						)
		}
		)
@SecurityScheme(
		name = "bearerAuth", 
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		in=SecuritySchemeIn.HEADER,
		scheme="bearer",
		description = "JWT auth"
		)	
public class OpenaiConfig {

}
