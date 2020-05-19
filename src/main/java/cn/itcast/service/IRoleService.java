package cn.itcast.service;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    List<User> findUserByRoleId(Integer roleId);

    void delUserFromRole(Integer userId, Integer roleId);
}
