package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from Role")
    List<Role> findAll();

    @Select("select * from user where id in (select user_id from user_role where role_id=#{roleId})")
    List<User> findUserByRoleId(Integer roleId);

    @Delete("delete from user_role where user_id=#{userId} and role_id=#{roleId}")
    void delUserFromRole(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    @Select("select * from role where id in (select role_id from user_role where user_id=#{userId})")
    List<Role> findRoleByUserId(Integer userId);

}
