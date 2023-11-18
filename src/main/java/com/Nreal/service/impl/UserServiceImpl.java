package com.Nreal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.RandomUtil;
import com.Nreal.dto.LoginFormDTO;
import com.Nreal.dto.Result;
import com.Nreal.dto.UserDTO;
import com.Nreal.entity.User;
import com.Nreal.mapper.UserMapper;
import com.Nreal.service.UserService;
import com.Nreal.utils.RegexUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.Nreal.utils.RedisConstants.*;
import static com.Nreal.utils.SystemConstants.USER_NICK_NAME_PREFIX;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-11-18 13:15:16
 */
@Service("userService")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result sendCode(String phone, HttpSession session) {
        if(RegexUtils.isPhoneInvalid(phone)){
            return Result.fail("手机号码格式错误！");
        }
        String code = RandomUtil.randomNumbers(6);
        //session登录
//        session.setAttribute("code",code);
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY+phone,code,LOGIN_CODE_TTL, TimeUnit.MINUTES);
        log.debug("发送验证码成功,验证码：{}",code);
        return Result.ok();
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        String phone = loginForm.getPhone();
        if(RegexUtils.isPhoneInvalid(phone)){
            return Result.fail("手机号码格式错误！");
        }
        //session方式
//        Object cacheCode = session.getAttribute("code");
//        String code = loginForm.getCode();
//        if(cacheCode==null || !cacheCode.toString().equals(code)){
//            return Result.fail("验证码错误！");
//        }
//        //select * from tb_user where phone = ?
//        User user = query().eq("phone", phone).one();
//        if(user == null){
//            user = createUserWithPhone(phone);
//        }
//        //用户脱敏
//        session.setAttribute("user", BeanUtil.copyProperties(user, UserDTO.class));
//        return Result.ok();

        //redis方式
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY+phone);
        String code = loginForm.getCode();
        if(cacheCode==null || !cacheCode.toString().equals(code)){
            return Result.fail("验证码错误！");
        }
        //select * from tb_user where phone = ?
        User user = query().eq("phone", phone).one();
        if(user == null){
            user = createUserWithPhone(phone);
        }
        //用户信息保存到redis 1.随机token作令牌 2.User对象转为HashMap存储
        String token = UUID.randomUUID().toString();
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        //id是long类型，存redis需要转换为string，要自定义序列化
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO, new HashMap<>(),
             CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        String tokenKey = LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(tokenKey,userMap);
        stringRedisTemplate.expire(tokenKey,LOGIN_USER_TTL,TimeUnit.SECONDS);
        return Result.ok(token);
    }

    private User createUserWithPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setNickName(USER_NICK_NAME_PREFIX+RandomUtil.randomString(10));
        save(user);
        return user;
    }
}
