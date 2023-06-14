package com.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/5/3
 */
@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private Integer sex;
}
