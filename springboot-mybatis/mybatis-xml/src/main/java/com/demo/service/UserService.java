package com.demo.service;

import com.demo.dao.UserMapper;
import com.demo.domain.User;
import com.demo.handler.ResultInfoHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * <p>
 * Create on 2022/07/10
 */
@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private UserService userService;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }


    public User getUser(Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @Transactional()
    public void save(User user) {
        userMapper.insert(user);

//        delete(46L);

    }

    public void update(User user) {
        userMapper.update(user);
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
    public void delete(Long id) {
        userMapper.delete(id);

    }

    public void selectUser(){
        List<User> users = userMapper.selectUsers(1000);
        System.out.println(users);
    }
    /**
     * 流式查询
     */
    public void getUserList(){

        ResultInfoHandler<User> handler = new ResultInfoHandler<>();
        Map<String,Object> param = new HashMap<>();
        param.put("id",20000);
        sqlSessionTemplate.select("com.demo.dao.UserMapper.getUsers",param,handler);
        handler.end();

    }


}
