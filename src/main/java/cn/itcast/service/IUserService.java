package cn.itcast.service;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    List<User> findUserByName(String searchText);


    void addUser(User user);

    void delUserById(Integer id);


    List<Role> findRoleNotIn(Integer id);

    void addRoleToUser(Integer userId, Integer roleId);

    User findUserById(Integer id);

    void updateUser(Integer id, String name, Integer status);

    User login(String username, String password);

    void updatePassword(Integer id, String newPassword);
}
