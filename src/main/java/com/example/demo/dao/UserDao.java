package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

public interface UserDao extends BaseMapper<User>{
    public List<User> selectAll();

    public User findUserByName(String loginName);

    User findUserById(String userId);

    void selectUsers(PageQuery<User> userPageQuery);
}