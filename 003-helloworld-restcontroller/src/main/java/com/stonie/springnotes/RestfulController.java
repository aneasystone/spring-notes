package com.stonie.springnotes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestfulController {

    /**
     * curl -X GET -iv http://localhost:8080/restful/string
     * 注意请求响应，Content-Type: text/plain;charset=UTF-8
     */
    @RequestMapping("/restful/string")
    public String restfulString() {
        return "restfulString";
    }

    /**
     * curl -X GET -i http://localhost:8080/restful/object
     * 注意请求响应：Content-Type: application/json
     */
    @RequestMapping("/restful/object")
    public Object restfulObject() {
        Map map = new HashMap();
        map.put("hello", "world");
        return map;
    }
}
