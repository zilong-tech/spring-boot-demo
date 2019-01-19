package com.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过 @ConfigurationProperties(prefix = "home”) 注解，
 * 将配置文件中以 home 前缀的属性值自动绑定到对应的字段中。
 * 同是用 @Component 作为 Bean 注入到 Spring 容器中。
 */
@Component
@ConfigurationProperties(prefix = "home")
public class HomeProperties {

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 描述
     */
    private String desc;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HomeProperties{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
