package com.demo;

import com.demo.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	public static Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);

	@Autowired
    RedisDao redisDao;

	@Test
	public void testRedis(){
		redisDao.setKey("name","hello");
		redisDao.setKey("age","11");
		logger.info(redisDao.getValue("name"));
		logger.info(redisDao.getValue("age"));

		redisDao.setHash("testHash","hello","world");
		logger.info("value:"+ redisDao.getHash("testHash","hello"));
	}
}
