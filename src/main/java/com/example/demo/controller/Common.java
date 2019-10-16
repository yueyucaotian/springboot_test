package com.example.demo.controller;

import com.example.demo.entity.JsonResult;
import com.example.demo.service.menu.MenuService;
import com.example.demo.service.menu.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/15 9:21
 */

@CrossOrigin
@RestController
public class Common {

    @Autowired
    MenuService menuService;

    @RequestMapping("/menu")
    public JsonResult getMenu(HttpServletRequest httpServletRequest) throws Exception{
        return menuService.getAllMenu(httpServletRequest);
    }
}
