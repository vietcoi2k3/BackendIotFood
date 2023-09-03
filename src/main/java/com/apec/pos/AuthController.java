package com.apec.pos;

import org.apache.http.HttpStatus;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheConfig;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.accountDto.LoginRequest;
import com.apec.pos.Dto.accountDto.LoginResponDto;
import com.apec.pos.Dto.otpDto.OtpRequestDto;
import com.apec.pos.Dto.otpDto.OtpResponseDto;
import com.apec.pos.Dto.otpDto.OtpValidationRequestDto;
import com.apec.pos.unitl.Validator;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.enu.ErrorCode;
import com.apec.pos.response.Response;
import com.apec.pos.service.AccountService;
import com.apec.pos.service.FoodService;
import com.apec.pos.service.RestaurantService;
import com.apec.pos.service.RoomService;
import com.apec.pos.service.SmsService;
import com.apec.pos.service.TypeFoodService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(value = "auth")
@CrossOrigin
@CacheConfig(cacheNames = "iotFood")
public class AuthController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private TypeFoodService typeFoodService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private RestaurantService restaurantService;


    @Operation(description = "'username'<=>'mã sinh viên'\n\n 'password'<=>'mật khẩu'",
            summary = "Đăng nhập")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
        LoginResponDto loginResponDto = accountService.login(loginRequest);
        if (loginResponDto == null) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new Response(true, "Tài Khoản Hoặc Mật Khẩu Không Chính Xác", ErrorCode.BAD_REQUEST));
        }
        return ResponseEntity.status(HttpStatus.SC_OK).body(new Response<LoginResponDto>(true, "Đăng nhập thành công", ErrorCode.SUCCESS, loginResponDto));
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<Response> register(@RequestBody AccountEntity accountEntity) {
//        if (!(Validator.validateStudentID(accountEntity.getUsername()) && Validator.validatePassword(accountEntity.getPassword()))) {
//            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new Response<>(false, "Tài khoàn hoặc mật khẩu không hợp lệ"));
//        }


        LoginResponDto loginResponDto = accountService.register(accountEntity);
        if (loginResponDto == null) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new Response(true, "Đăng kí thất bại,tài khoản đã tồn tại", ErrorCode.BAD_REQUEST));
        }

        return ResponseEntity.ok(new Response(true, "Đăng kí thành công", ErrorCode.SUCCESS, loginResponDto));
    }

    @Operation(description = "lấy ra danh sách các món ăn được đề xuất,hiện tại đang là 10 món", summary = "lấy ra các món ăn đề xuất")
    @RequestMapping(value = "get-recommend-food", method = RequestMethod.GET)
    public Response getRecommendFood() {
        return new Response<>(true, "lấy thành công", ErrorCode.SUCCESS, foodService.getFoodRecommand());
    }

    @Operation(summary = "lấy ra các type food")
    @RequestMapping(value = "get-all-type", method = RequestMethod.GET)
    public Response getTypeFood() {
        return new Response<>(true, "lấy ra các loại món ăn", ErrorCode.SUCCESS, typeFoodService.findAll());
    }

    @PostMapping("/send-otp")
    public OtpResponseDto sendOtp(@RequestBody OtpRequestDto otpRequest) {
        System.out.println("inside sendOtp :: " + otpRequest.getUsername());
        return smsService.sendSMS(otpRequest);
    }

    @PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequestDto otpValidationRequest) {
        System.out.println("inside validateOtp :: " + otpValidationRequest.getUsername() + " " + otpValidationRequest.getOtpNumber());
        return smsService.validateOtp(otpValidationRequest);
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ResponseEntity hello() {
        return ResponseEntity.status(HttpStatus.SC_OK).body("Welcome to IOT-FOOT");
    }

    @Operation(summary = "tìm kiếm món ăn theo type,detail,tên món ăn")
    @RequestMapping(value = "search-food", method = RequestMethod.POST)
    public ResponseEntity searchFood(@RequestParam(required = false) String searchString) {
        return ResponseEntity.ok(new Response(true, "lấy thành công", ErrorCode.SUCCESS, foodService.searchFood(searchString)));
    }

    @Operation(summary = "lấy ra detail food", description = "khi bấm vào một món ăn sẽ gọi đến api này")
    @RequestMapping(value = "get-detail-food", method = RequestMethod.POST)
    public ResponseEntity getDetailFood(@RequestParam Integer id) {
        return ResponseEntity.ok(new Response(true, "lấy thành công", ErrorCode.SUCCESS, foodService.getDetailFood(id)));
    }

    @Operation(summary = "lấy ra danh sách cửa hàng đề xuất")
    @RequestMapping(value = "get-recommend-res", method = RequestMethod.GET)
    public ResponseEntity getRecommendRes() {
        return ResponseEntity.ok(new Response<>(true, "lấy thành công", ErrorCode.SUCCESS, restaurantService.getRecommendRes()));
    }

    @Operation(summary = "lấy ra restaurant detail", description = "quantitySold = 'Số lượng đã bán'\n\n quantityPurchased = 'số lượng đã mua'")
    @RequestMapping(value = "get-detail-res", method = RequestMethod.POST)
    public ResponseEntity getDetailRes(@RequestParam Integer id) {
        return ResponseEntity.ok(new Response(true, "lấy thành công", ErrorCode.SUCCESS, restaurantService.getResdetail(id)));
    }

    @RequestMapping(value = "/paging-res", method = RequestMethod.POST)
    public ResponseEntity pagingRes(@RequestParam Integer pageSize, @RequestParam Integer pageIndex) {
        return ResponseEntity.ok(new Response(true, "", restaurantService.paging(pageSize, pageIndex)));
    }

//	@RequestMapping(method = RequestMethod.GET,value = "get-user-lazy")
//	public ResponseEntity testLazy(){
//		FoodEntity foodEntity = foodService.findOne(2);
//
//		return ResponseEntity.ok(foodEntity.getRestaurantEntity());
//	}
}
