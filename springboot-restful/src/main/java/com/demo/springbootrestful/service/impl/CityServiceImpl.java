package com.demo.springbootrestful.service.impl;

import com.demo.springbootrestful.dao.CityDao;
import com.demo.springbootrestful.pojo.City;
import com.demo.springbootrestful.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
