package com.Nreal.service.impl;

import com.Nreal.entity.Blog;
import com.Nreal.mapper.BlogMapper;
import com.Nreal.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Blog)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:15
 */
@Service("blogService")
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
