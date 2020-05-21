package cn.itcast.utils;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;

import java.util.List;

public class testIsAdmin {

    public static Boolean isAdmin(User user){
        String str = "ADMIN";
        List<Role> roles = user.getRoleList();
        if (user!=null&&roles!=null){
            for (int i=0;i<roles.size();i++){
                String name=roles.get(i).getName();
                if(name.equals(str)){
                    return true;
                }
            }
        }
        return false;
    }

}
