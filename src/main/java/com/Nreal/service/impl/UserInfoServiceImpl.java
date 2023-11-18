package com.Nreal.service.impl;

import com.Nreal.entity.UserInfo;
import com.Nreal.mapper.UserInfoMapper;
import com.Nreal.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:16
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
