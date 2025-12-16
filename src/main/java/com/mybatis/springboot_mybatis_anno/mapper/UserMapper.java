package com.mybatis.springboot_mybatis_anno.mapper;

import com.mybatis.springboot_mybatis_anno.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT id, name, email FROM users WHERE id = #{id}")
    User getUserById(@Param("id") Integer id);

    @Select("SELECT id, name, email FROM users")
    List<User> getAllUsers();

    @Insert("INSERT INTO users(name, email) VALUES(#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    @Update("UPDATE users SET name=#{name}, email=#{email} WHERE id=#{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void deleteUser(@Param("id") Integer id);
}
