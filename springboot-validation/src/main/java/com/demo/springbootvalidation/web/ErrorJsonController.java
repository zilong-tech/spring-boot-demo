package com.demo.springbootvalidation.web;


import com.demo.springbootvalidation.constant.CityErrorInfoEnum;
import com.demo.springbootvalidation.result.GlobalErrorInfoException;
import com.demo.springbootvalidation.result.ResultBody;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 错误码案例
 *
 */
@RestController
public class ErrorJsonController {


    /**
     * 获取城市接口
     *
     * @param cityName
     * @return
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public ResultBody findOneCity(@RequestParam("cityName") String cityName) throws GlobalErrorInfoException {
        // 入参为空
        if (StringUtils.isEmpty(cityName)) {
            throw new GlobalErrorInfoException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
        }else if("2".equals(cityName)){
            throw new GlobalErrorInfoException(CityErrorInfoEnum.CITY_EXIT);
        }
        return new ResultBody(new City(1L,2L,cityName,"是我的故乡"));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void save(@Valid @RequestBody City city){
        System.out.println(city.toString());
    }


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void test(@Valid @RequestBody City city){

    }


    /**
     * 使用Defaul分组进行验证
     * @param
     * @return
     */
    @PostMapping("/validate")
    public String addUser(@Validated(value = User.Default.class) @RequestBody User user) {
        return "validate";
    }

    /**
     * 使用Update分组进行验证
     * @param
     * @return
     */
    @PutMapping("/validate1")
    public String updateUser(@Validated(value = {User.Update.class}) @RequestBody User user) {
        return "validate1";
    }
}