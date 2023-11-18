package com.Nreal.service.impl;

import com.Nreal.entity.VoucherOrder;
import com.Nreal.mapper.VoucherOrderMapper;
import com.Nreal.service.VoucherOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (VoucherOrder)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:16
 */
@Service("voucherOrderService")
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements VoucherOrderService {

}
