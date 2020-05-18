package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where name like CONCAT('%',#{searchText},'%')")
    List<User> findUserByName(String searchText);

    @Insert("insert into user (name,password,status) values (#{name},#{password},#{status})")
    void addUser(User user);

    @Delete("delete from user where id=#{id}")
    void delUserById(Integer id);

    @Select("select * from role where id not in (select role_id from user_role where user_id=#{id})")
    List<Role> findRoleNotIn(Integer id);

    @Insert("insert into user_role (user_id,role_id) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

    @Update("update user set name=#{name},status=#{status} where id=#{id}")
    void updateUser(@Param("id")Integer id,@Param("name")String name,@Param("status")Integer status);
}
