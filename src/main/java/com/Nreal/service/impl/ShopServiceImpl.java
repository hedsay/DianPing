package com.Nreal.service.impl;

import com.Nreal.entity.Shop;
import com.Nreal.mapper.ShopMapper;
import com.Nreal.service.ShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Shop)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:15
 */
@Service("shopService")
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

}
