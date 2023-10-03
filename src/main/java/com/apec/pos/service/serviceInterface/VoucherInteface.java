package com.apec.pos.service.serviceInterface;

import com.apec.pos.dto.voucherDTO.VoucherRequest;
import com.apec.pos.dto.voucherDTO.VoucherResponse;
import com.apec.pos.entity.VoucherEntity;

import java.util.List;

public interface VoucherInteface {
    public VoucherResponse useVoucher(VoucherRequest voucherRequest) throws Exception;

    public VoucherResponse pagingVoucher(Integer pageIndex,Integer pageSize);
}
