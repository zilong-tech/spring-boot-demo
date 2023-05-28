package com.demo;

import com.demo.entity.Article;
import com.demo.mapper.ArticleMapper;
import org.dromara.easyes.core.core.EsWrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * <p>
 * Create on 2023/05/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEs {

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void insert() {
        Article article = new Article();
        article.setTitle("欢迎");
        article.setContent("欢迎关注开源小分队");
        int successCount = articleMapper.insert(article);
        System.out.println(successCount);
    }


    @Test
    public void select() {
        String title = "欢迎";
        Article article = EsWrappers.lambdaChainQuery(articleMapper)
                .eq(Article::getTitle, title)
                .one();
        System.out.println(article);
    }



}
