package com.Nreal.service.impl;

import com.Nreal.entity.BlogComments;
import com.Nreal.mapper.BlogCommentsMapper;
import com.Nreal.service.BlogCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (BlogComments)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:15
 */
@Service("blogCommentsService")
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments> implements BlogCommentsService {

}
