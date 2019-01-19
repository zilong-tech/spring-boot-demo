package com.demo.springbootvalidationoverjson.web;


import com.demo.springbootvalidationoverjson.constant.CityErrorInfoEnum;
import com.demo.springbootvalidationoverjson.result.GlobalErrorInfoException;
import com.demo.springbootvalidationoverjson.result.ResultBody;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
     * @throws GlobalErrorInfoException
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
}