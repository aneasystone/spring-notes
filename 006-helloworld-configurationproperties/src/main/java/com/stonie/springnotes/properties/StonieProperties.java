package com.stonie.springnotes.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@ConfigurationProperties(prefix = "com.stonie")
public class StonieProperties {

    private String helloTitle;
    private String helloName;

    public String getHelloTitle() {
        return helloTitle;
    }

    public void setHelloTitle(String helloTitle) {
        this.helloTitle = helloTitle;
    }

    public String getHelloName() {
        return helloName;
    }

    public void setHelloName(String helloName) {
        this.helloName = helloName;
    }
}
