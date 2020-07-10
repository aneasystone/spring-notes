package com.stonie.springnotes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }
}
