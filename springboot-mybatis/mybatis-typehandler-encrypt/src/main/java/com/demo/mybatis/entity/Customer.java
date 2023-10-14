package com.demo.mybatis.entity;

import com.demo.mybatis.typehandler.Encrypt;

import java.util.List;

/**
 * @author huan.fu 2021/5/18 - 上午10:42
 */
public class Customer {
    
    private Integer id;
    
    private Encrypt phone;
    
    private List<String> address;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Encrypt getPhone() {
        return phone;
    }
    
    public void setPhone(Encrypt phone) {
        this.phone = phone;
    }
    
    public List<String> getAddress() {
        return address;
    }
    
    public void setAddress(List<String> address) {
        this.address = address;
    }
}
