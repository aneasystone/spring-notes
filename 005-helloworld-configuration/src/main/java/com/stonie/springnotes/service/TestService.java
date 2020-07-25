package com.stonie.springnotes.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestService {

    public Integer add(Integer a, Integer b) {
        if (a == null || b == null) {
            return 0;
        }
        return a + b;
    }

    public Integer sub(Integer a, Integer b) {
        if (a == null || b == null) {
            return 0;
        }
        return a - b;
    }

    @PostConstruct
    private void init() {
        System.out.println("initializing test service...");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("destroying test service...");
    }
}
