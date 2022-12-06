package com.demo.handler;


import com.demo.domain.User;
import com.demo.util.SpringBeanUtil;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;


public class ResultInfoHandler<T extends User> implements ResultHandler<T> {

    /**
     * 每批处理的大小
     */
    private int batchSize = 100;
    private int size;

    /**
     * 存储每批数据的临时容器
     */
    private List<User> list = new ArrayList<>();

    public List<User> getList(){
        return list;
    }


    @Override
    public void handleResult(ResultContext resultContext) {
        T t = (T) resultContext.getResultObject();
        list.add(t);
        size++;
        if (size == batchSize) {
            handle();
        }
    }

    public void handle() {
        try {
            StringRedisTemplate template = SpringBeanUtil.getBean(StringRedisTemplate.class);

            List<User> list = getList();
            for (int i = 0; i < list.size(); i++) {
                template.opsForHash().put("username",list.get(i).getUserName(),list.get(i).getUserName());

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            size = 0;
            list.clear();
        }
    }

    public void end(){
        handle();
    }

}
