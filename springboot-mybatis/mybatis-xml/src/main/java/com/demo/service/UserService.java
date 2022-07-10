package com.demo.service;

import com.demo.dao.UserMapper;
import com.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * <p>
 * Create on 2022/07/10
 */
@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }


    public User getUser(Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    public void save(User user) {
        userMapper.insert(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(Long id) {
        userMapper.delete(id);
    }


}
