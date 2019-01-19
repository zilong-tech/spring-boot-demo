package com.test;


import com.demo.web.controller.HelloWorldController;
import org.junit.Test;

import static org.junit.Assert.*;


public class HelloWorldControllerTest {

    @Test
    public void testSayHello(){
        assertEquals("Hello,World!",new HelloWorldController().sayHello());
    }

}
