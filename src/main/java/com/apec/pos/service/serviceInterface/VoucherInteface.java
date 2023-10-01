package com.apec.pos.service.serviceInterface;

import com.apec.pos.dto.voucherDTO.VoucherRequest;
import com.apec.pos.dto.voucherDTO.VoucherResponse;
import com.apec.pos.entity.VoucherEntity;

import java.util.List;

public interface VoucherInteface {
    public VoucherResponse useVoucher(VoucherRequest voucherRequest) throws Exception;

    public List<VoucherEntity> pagingVoucher(Integer pageIndex,Integer pageSize);
}
