package com.stonie.springnotes;

import com.stonie.springnotes.service.TestService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class ConfigurationController {

    private TestService testService;

    public ConfigurationController(TestService testService) {
        this.testService = testService;
        System.out.println(this.testService);
    }

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/add")
    public Integer add(Integer a, Integer b) {
        return testService.add(a, b);
    }

    @RequestMapping("/sub")
    public Integer sub(Integer a, Integer b) {
        return testService.sub(a, b);
    }
}
