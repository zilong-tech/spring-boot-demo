package com.demo.springbootrestful.service.impl;

import com.demo.springbootrestful.dao.CityDao;
import com.demo.springbootrestful.pojo.City;
import com.demo.springbootrestful.service.CityService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityDao cityDao;

    @Override
    public List<City> findAllCity() {
        return cityDao.findAllCity();
    }

    @Override
    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }

    @Override
    @Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 100))
    public void retry(int code) throws Exception {

        System.out.println("test被调用,时间："+ LocalDateTime.now());
        if (code == 0){
            throw new Exception("===========出现异常了！===========");
        }
        System.out.println("方法执行结束=============");
    }

    @Recover
    public void recover(Exception e, int code){
        System.out.println("回调方法执行！！！！");
        System.out.println("retryParam参数值为："+ code);

        //记日志到数据库 或者调用其余的方法
        System.out.println("异常信息:"+e.getMessage());

    }


}
