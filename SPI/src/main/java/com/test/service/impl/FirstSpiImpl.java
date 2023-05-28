package com.test.service.impl;

import com.test.service.ISpi;

public class FirstSpiImpl implements ISpi {

    @Override
    public void say() {
        System.out.println("我是第一个SPI实现类");
    }
}
