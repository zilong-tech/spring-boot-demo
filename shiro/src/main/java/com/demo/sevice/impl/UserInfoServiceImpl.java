package com.demo.sevice.impl;

import com.demo.dao.UserInfoDao;
import com.demo.model.UserInfo;
import com.demo.model.UserInfoQuery;
import com.demo.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
//        UserInfoQuery userInfoQuery = new UserInfoQuery();
//        userInfoQuery.createCriteria().andUsernameEqualTo(username);
//        List<UserInfo> userInfoList = userInfoDao.selectByExample(userInfoQuery);
        UserInfo userInfo = userInfoDao.selectUserInfo(username);
        if(userInfo != null){
            return userInfo;
        }
        return null;

    }
}