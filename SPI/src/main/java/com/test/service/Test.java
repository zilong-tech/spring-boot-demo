package com.test.service;


import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {
        ServiceLoader<ISpi> serviceLoader = ServiceLoader.load(ISpi.class);
        for (ISpi service : serviceLoader) {

            service.say();
        }


    }
}
