package com.demo.entity;

import lombok.Data;

/**
 * Description:
 * <p>
 * Create on 2023/05/28
 *
 */
@Data
public class Goods {

    //商品ID
    private String id ;

    //名称
    private String name;

    //描述
    private String description;

    //价格
    private Double price;
}
