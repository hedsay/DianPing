package com.Nreal.service.impl;

import com.Nreal.entity.Follow;
import com.Nreal.mapper.FollowMapper;
import com.Nreal.service.FollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Follow)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:15
 */
@Service("followService")
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {

}
