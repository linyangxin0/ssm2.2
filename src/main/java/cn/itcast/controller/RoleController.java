package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public @ResponseBody List<Role> findAll(){
        return roleService.findAll();
    }

    @RequestMapping("/findUserByRoleId.do")
    public @ResponseBody List<User> findUserByRoleId(Integer id){
        return roleService.findUserByRoleId(id);
    }

    @RequestMapping("/delUserFromRole.do")
    public @ResponseBody void delUserFromRole(Integer userId,Integer roleId){
        roleService.delUserFromRole(userId,roleId);
    }


}
