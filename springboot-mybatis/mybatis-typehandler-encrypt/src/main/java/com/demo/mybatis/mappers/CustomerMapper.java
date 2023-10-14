package com.demo.mybatis.mappers;

import com.demo.mybatis.entity.Customer;
import com.demo.mybatis.typehandler.Encrypt;
import org.apache.ibatis.annotations.Param;


public interface CustomerMapper {

    int addCustomer(@Param("phone") Encrypt phone, @Param("address") String address);

    Customer findCustomer(@Param("phone") Encrypt phone);
}
