package com.test;

import com.demo.Application;
import com.demo.property.HomeProperties;
import com.demo.property.UserProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PropertiesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesTest.class);

    @Resource
    private UserProperties userProperties;

    @Resource
    private HomeProperties homeProperties;

    @Test
    public void getHomeProperties() {
        LOGGER.info("\n\n" + homeProperties.toString() + "\n");
    }

    @Test
    public void randomTestUser() {
        LOGGER.info("\n\n" + userProperties.toString() + "\n");
    }
}
