package com.example.demo.service.menu;

import com.example.demo.pojo.Menu;
import org.springframework.beans.BeanUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/14 17:58
 */
public class MenuTree extends Menu {
    private List<MenuTree> children;

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }

    public MenuTree(Menu model) {
        if(model!=null)
            BeanUtils.copyProperties(model,this);
    }

    public void addChild(MenuTree child){
        if(children==null) children = new ArrayList<MenuTree>();
        children.add(child);
    }
}
