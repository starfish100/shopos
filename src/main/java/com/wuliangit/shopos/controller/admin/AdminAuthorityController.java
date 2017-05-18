package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.AdminDTO;
import com.wuliangit.shopos.dto.AdminRoleDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 江建平 on 2017/5/12.
 * @description 管理员权限控制器
 */
@Controller
@RequestMapping("/admin/authority")
public class AdminAuthorityController {
    @Autowired
    private AdminService adminService;
    /**
     * 管理员列表页面
     * @return
     */
    @RequestMapping("/adminListPage")
    public String allAdminListPage(){
        return "admin/authority/admin_list";
    }

    /**
     * 管理员添加页面
     * @return
     */
    @RequestMapping("/addAdminPage")
    public String addAdminPage(){
        return "/admin/authority/add_admin";
    }

    /**
     * 角色列表页面
     * @return
     */
    @RequestMapping("/roleListPage")
    public String roleListPage(){
        return "/admin/authority/role_list";
    }

    /**
     * 添加角色页面
     * @return
     */
    @RequestMapping("/addRolePage")
    public String addRolePage(){
        return "/admin/authority/add_role";
    }

    /**
     * 编辑管理员页面
     * @return
     */
    @RequestMapping("/editAdminPage")
    public String editAdminPage(Integer adminId, Model model){
        model.addAttribute("adminInfo", adminService.getAdminById(adminId));
        return "/admin/authority/edit_admin_authority";
    }
    /**
     * 查询所有管理员
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/searchAdminList")
    @ResponseBody
    public Object searchAdminList(@RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<AdminDTO> list = adminService.searchAdminList(page, pageSize, orderColumn, orderType, searchKey);
        return new PageResult<AdminDTO>(list, draw);
    }

    /**
     * 获得所有角色
     * @return
     */
    @RequestMapping("/getAllRoles")
    @ResponseBody
    public Object getAllRoles(){
        RestResult result = new RestResult();
        ArrayList<AdminRoleDTO> roleList = adminService.getAllAdminRoles();
        result.add("roleList",roleList);
        return result;
    }

    /**
     * 添加管理员
     * @param username
     * @param password
     * @param adminRoleId
     * @return
     */
    @RequestMapping("/addAdmin")
    @ResponseBody
    public Object addAdmin(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("adminRoleId") Integer adminRoleId){
        RestResult result = new RestResult();
        Admin adminCheck = adminService.getByUsername(username);
        if(adminCheck != null) {
            result.setCode(202);
            result.setMsg("该管理员已存在");
            return result;
        }
        Admin admin = new Admin();
        admin.setAdminRoleId(adminRoleId);
        admin.setCreateTime(new Date());
        admin.setSalt(PasswordHelper.generateSalt());
        admin.setPassword(PasswordHelper.generatePassword(password, admin.getSalt()));
        admin.setUsername(username);
        if(adminService.createAdmin(admin) != 1){
            result.setCode(502);
            result.setMsg("添加失败");
            return result;
        }
        return result;
    }
}
