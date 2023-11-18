package com.Nreal.service.impl;

import com.Nreal.entity.SeckillVoucher;
import com.Nreal.mapper.SeckillVoucherMapper;
import com.Nreal.service.SeckillVoucherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 秒杀优惠券表，与优惠券是一对一关系(SeckillVoucher)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:15
 */
@Service("seckillVoucherService")
public class SeckillVoucherServiceImpl extends ServiceImpl<SeckillVoucherMapper, SeckillVoucher> implements SeckillVoucherService {

}
