package com.example.demo.service.menu;

import com.auth0.jwt.JWT;
import com.example.demo.dao.MenuDao;
import com.example.demo.entity.JsonResult;
import com.example.demo.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/14 17:27
 */

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;

    public JsonResult getAllMenu(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("access_token");
        String userId  = JWT.decode(token).getAudience().get(0);
        List<Menu> menuList = menuDao.selectAllMenu(userId);
        MenuTree menuTree = walkMenu(menuList);
        return JsonResult.builder()
                .code("0000")
                .message("")
                .data(menuTree)
                .build();
    }

    private MenuTree walkMenu(List<Menu> menuList){
        if(menuList==null)
            return null;
        List<MenuTree> menuEntityList = new ArrayList<MenuTree>();
        for(Menu model : menuList){
            menuEntityList.add(new MenuTree(model));
        }

        Map<Long,MenuTree> temp = new HashMap();
        for(MenuTree model:menuEntityList){
            temp.put((long) model.getId(),model);
        }

        MenuTree root = new MenuTree(null);

        for(MenuTree model : menuEntityList){
            if(model.getParentId()==null||model.getParentId()==0){
                root.addChild(model);
            } else {
                Long parentId = model.getParentId();
                MenuTree parent = temp.get(parentId);
                if(parent==null)
                    continue;
                parent.addChild(model);
            }
        }
        return root;
    }
}
