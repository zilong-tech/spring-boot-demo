package com.test.service.impl;

import com.test.service.ISpi;

public class SecondSpiImpl implements ISpi {

    @Override
    public void say() {
        System.out.println("我是第二个SPI实现类");
    }
}
