package com.Nreal.service;

import com.Nreal.dto.LoginFormDTO;
import com.Nreal.dto.Result;
import com.Nreal.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-11-18 13:15:16
 */
public interface UserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);
}
