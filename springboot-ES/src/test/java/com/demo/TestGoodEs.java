package com.demo;

import com.demo.entity.Article;
import com.demo.entity.Goods;
import com.demo.mapper.ArticleMapper;
import com.demo.mapper.GoodsMapper;
import org.dromara.easyes.core.conditions.select.LambdaEsQueryWrapper;
import org.dromara.easyes.core.core.EsWrappers;
import org.elasticsearch.action.search.SearchResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * Description:
 * <p>
 * Create on 2023/05/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGoodEs {

    @Autowired
    GoodsMapper goodsMapper;

    @Test
    public void insert() {

        Goods goods = new Goods();
        goods.setId(UUID.randomUUID().toString());
        goods.setName("手机 HUAWEI P60 Pro");
        goods.setDescription("超聚光 XMAGE 影像，超聚光夜视长焦 | 超可靠昆仑玻璃，玲珑四曲屏 | 双向北斗卫星消息，灵犀通信，88 W 超级快充 Turbo");
        int successCount = goodsMapper.insert(goods);
        System.out.println(successCount);
    }

    @Test
    public void delete() {

        LambdaEsQueryWrapper<Goods> wrapper = new LambdaEsQueryWrapper<>();

        wrapper.like(Goods::getName,"手机");
        int successCount = goodsMapper.delete(wrapper);
        System.out.println(successCount);
    }



    @Test
    public void select() {
        String name = "手机";
        LambdaEsQueryWrapper<Goods> wrapper = new LambdaEsQueryWrapper<>();
        wrapper.like(Goods::getName, name)
                .limit(10);
        List<Goods> goods = goodsMapper.selectList(wrapper);
        System.out.println(goods);
    }



}
