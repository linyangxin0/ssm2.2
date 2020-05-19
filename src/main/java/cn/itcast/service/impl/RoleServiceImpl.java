package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public List<User> findUserByRoleId(Integer roleId) {
        return roleDao.findUserByRoleId(roleId);
    }

    @Override
    public void delUserFromRole(Integer userId, Integer roleId) {
        roleDao.delUserFromRole(userId,roleId);
    }
}
