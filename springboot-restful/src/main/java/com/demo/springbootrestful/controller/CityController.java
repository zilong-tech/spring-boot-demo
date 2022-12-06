package com.demo.springbootrestful.controller;

import com.demo.springbootrestful.pojo.City;
import com.demo.springbootrestful.service.CityService;
import com.demo.springbootrestful.utlis.JpushUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * method - 指定请求的方法类型：POST/GET/DELETE/PUT 等
 * value - 指定实际的请求地址
 * consumes - 指定处理请求的提交内容类型，例如 Content-Type 头部设置application/json, text/html
 * @PathVariable URL 映射时，用于绑定请求参数到方法参数
 * @RequestBody 这里注解用于读取请求体 body 的数据，通过 HttpMessageConverter 解析绑定到对象中
 * @ResponseBody 作用： 该注解用于将 Controller 的方法返回的对象，通过适当的 HttpMessageConverter 转换为指定格式后，
 * 写入到 Response 对象的 body 数据区。
 * HTTP 知识补充
 * GET            请求获取Request-URI所标识的资源
 * POST          在Request-URI所标识的资源后附加新的数据
 * HEAD         请求获取由Request-URI所标识的资源的响应消息报头
 * PUT            请求服务器存储一个资源，并用Request-URI作为其标识
 * DELETE       请求服务器删除Request-URI所标识的资源
 * TRACE        请求服务器回送收到的请求信息，主要用于测试或诊断
 * CONNECT  保留将来使用
 * OPTIONS   请求查询服务器的性能，或者查询与资源相关的选项和需求
 */
@RestController
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}",method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        JpushUtil.testSendPushWithCustomConfig();
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }


    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }

    @RequestMapping(value = "/test")
    public void test(int code) throws Exception {
         cityService.retry(code);
    }
}
