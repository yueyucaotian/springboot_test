package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.JsonResult;
import com.example.demo.pojo.User;
import com.example.demo.vo.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired()
    UserDao userDao;

    @Autowired
    TokenService tokenService;

    public List<User> selectAll(){
        return userDao.selectAll();
    }

    public JsonResult findUserByName(login login){
        User user = userDao.findUserByName(login.getUsername());
        if(user==null){
            return JsonResult.builder()
                    .code("0001")
                    .message("用户不存在")
                    .data("")
                    .build();

        } else {
            if(!user.getPwd().equals(login.getPassword())){
                return JsonResult.builder()
                        .code("0001")
                        .message("登录失败，密码错误")
                        .data("")
                        .build();
            } else {
                String token = tokenService.getToken(user);
                user.setToken(token);
                user.setPwd("");
                return JsonResult.builder()
                        .code("0000")
                        .message("登陆成功")
                        .data(user)
                        .build();
            }
        }
    }

    public User findUserById(String id){
        return userDao.findUserById(id);
    }
}
