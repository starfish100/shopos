package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.PermissionMapper;
import com.wuliangit.shopos.dto.MenuDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.service.PerminssionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nilme on 2017/5/12.
 */

@Service
public class PerminssionServiceImpl implements PerminssionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<MenuDTO> getAdminMenus() {

        Admin admin = WebUtil.getCurrentAdmin();

        List<MenuDTO> menus = permissionMapper.getAdminMenus(admin.getAdminId());

        try {
            List<MenuDTO> menuList = handleSubType(menus, 0);
            return menuList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    /**
     * 生成多级菜单
     *
     * @param menus 要整理的分类项
     * @param id 根节点
     * @return
     */
    private static List<MenuDTO> handleSubType(List<MenuDTO> menus, Integer id) {
        List<MenuDTO> rtnlist = new ArrayList<MenuDTO>();
        for (MenuDTO menu : menus) {
            if (menu.getParentId().equals(id)) {
                menu.setChildMenus(handleSubType(menus, menu.getPermissionId()));
                rtnlist.add(menu);
            }
        }
        return rtnlist;
    }

}