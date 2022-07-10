package com.demo.controller;

import com.demo.domain.City;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @RequestMapping("/getCity")
    @Cacheable(value="city-key")
    public City getCity() {

        City city = new City("北京","首都");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return city;
    }
}