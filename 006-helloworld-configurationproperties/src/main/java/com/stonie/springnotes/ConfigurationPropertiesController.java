package com.stonie.springnotes;

import com.stonie.springnotes.properties.StonieProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationPropertiesController {

    private StonieProperties stonieProperties;

    public ConfigurationPropertiesController(StonieProperties stonieProperties) {
        this.stonieProperties = stonieProperties;
    }

    @RequestMapping("/")
    public String index() {
        return String.format("%s %s!",
                this.stonieProperties.getHelloTitle(),
                this.stonieProperties.getHelloName());
    }
}
