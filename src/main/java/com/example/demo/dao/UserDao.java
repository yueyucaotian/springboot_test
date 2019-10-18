package com.example.demo.dao;

import com.example.demo.pojo.User;
import com.example.demo.vo.login;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

public interface UserDao extends BaseMapper<User>{
    public List<User> selectAll();

    public User findUserByName(login login);

    User findUserById(String userId);

    void selectUsers(PageQuery<User> userPageQuery);
}