package cn.itcast.controller;

import cn.itcast.domain.Device;
import cn.itcast.domain.Role;
import cn.itcast.domain.Song;
import cn.itcast.domain.User;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public @ResponseBody List<User> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/findUserByName.do")
    public @ResponseBody List<User> findUserByName(String searchText){
        return userService.findUserByName(searchText);
    }

    @RequestMapping("/addUser.do")
    public @ResponseBody void addUser(@RequestParam(value="name") String name,
                                           @RequestParam(value="status") Integer status){

        User user = new User();

        user.setName(name);
        user.setStatus(status);
        user.setPassword("123");

        userService.addUser(user);
    }

    @RequestMapping("/delUserById.do")
    public @ResponseBody void delUserById(Integer id){
        userService.delUserById(id);
    }



    @RequestMapping("/findRoleNotIn.do")
    public @ResponseBody List<Role> findRoleNotIn(Integer id){
        return userService.findRoleNotIn(id);
    }

    @RequestMapping("/addRoleToUser.do")
    public @ResponseBody void addRoleToUser(@RequestParam(value="userId") Integer userId,
                                            @RequestParam(value="roleId") Integer roleId){
        userService.addRoleToUser(userId,roleId);
    }


    @RequestMapping("/findUserById.do")
    public @ResponseBody User findUserById(Integer id){
        return userService.findUserById(id);
    }

    @RequestMapping("/updateUser.do")
    public @ResponseBody void updateUser(@RequestParam(value="id") Integer id,
                                         @RequestParam(value="name") String name,
                                         @RequestParam(value="status") Integer status){

        userService.updateUser(id,name,status);
    }

}
