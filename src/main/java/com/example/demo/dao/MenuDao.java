package com.example.demo.dao;

import com.example.demo.pojo.Menu;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/14 17:27
 */
public interface MenuDao extends BaseMapper<Menu> {

    List<Menu> selectAllMenu(String userId);
}
