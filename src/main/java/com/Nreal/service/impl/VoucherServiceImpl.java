package com.Nreal.service.impl;

import com.Nreal.entity.Voucher;
import com.Nreal.mapper.VoucherMapper;
import com.Nreal.service.VoucherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Voucher)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:16
 */
@Service("voucherService")
public class VoucherServiceImpl extends ServiceImpl<VoucherMapper, Voucher> implements VoucherService {

}
