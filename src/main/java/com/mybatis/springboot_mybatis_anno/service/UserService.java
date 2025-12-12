package com.mybatis.springboot_mybatis_anno.service;

import com.mybatis.springboot_mybatis_anno.mapper.UserMapper;
import com.mybatis.springboot_mybatis_anno.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
