package com.demo.model;

import lombok.Data;

/**
 * Description:
 * <p>
 * Create on 2019/02/26
 *
 * @author zouyongsheng
 */
@Data
public class Message {

    public String message;

    public String date;

    public Message(){}

    public Message(String message){
        this.message = message;
    }
}
