package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.accountDto.*;
import com.apec.pos.entity.AccountEntity;

import java.io.IOException;
import java.util.List;

public interface AccountInterface {

    public LoginResponDto login(LoginRequest loginRequest);

    public LoginResponDto register(AccountEntity accountEntity);

    public AccountInfoDto getUserInfo(String token);

    public LoginResponDto addEmployee(RegisterRequest registerRequest);

    public AccountInfoDto updateAccountInfo(RegisterRequest updateRequest) throws Exception;

    public AccountResponseAdmin paging(Integer pageSize, Integer pageIndex);

    public LoginResponDto updateEmployee(UpdateAccountRequest updateAccountRequest) throws IOException;

    public void deleteAccount();

    public List<LoginResponDto> pagingEmployee(Integer pageSize, Integer pageIndex);
}
