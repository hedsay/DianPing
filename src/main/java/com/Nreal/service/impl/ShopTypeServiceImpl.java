package com.Nreal.service.impl;

import com.Nreal.entity.ShopType;
import com.Nreal.mapper.ShopTypeMapper;
import com.Nreal.service.ShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (ShopType)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:15
 */
@Service("shopTypeService")
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements ShopTypeService {

}
