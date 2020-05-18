package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findUserByName(String searchText) {
        return userDao.findUserByName(searchText);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void delUserById(Integer id) {
        userDao.delUserById(id);
    }

    @Override
    public List<Role> findRoleNotIn(Integer id) {
        return userDao.findRoleNotIn(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer roleId) {
        userDao.addRoleToUser(userId,roleId);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(Integer id, String name, Integer status) {
        userDao.updateUser(id,name,status);
    }


}
