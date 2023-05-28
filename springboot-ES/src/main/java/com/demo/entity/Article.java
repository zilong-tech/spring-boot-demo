package com.demo.entity;

import lombok.Data;

@Data
public class Article {
    /**
     * es中的唯一id
     */	
    private String id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
}
