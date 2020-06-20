package com.stonie.springnotes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class NormalController {

    /**
     * curl -X GET -iv http://localhost:8080/normal/string
     * 注意请求响应，Content-Type: text/plain;charset=UTF-8
     */
    @RequestMapping("/normal/string")
    public @ResponseBody String normalString() {
        return "normalString";
    }

    /**
     * curl -X GET -i http://localhost:8080/normal/object
     * 注意请求响应：Content-Type: application/json
     */
    @RequestMapping("/normal/object")
    public @ResponseBody Object normalObject() {
        Map map = new HashMap();
        map.put("hello", "world");
        return map;
    }

    /**
     * This is a 404 request, because there is no views named 'normalStringWithoutResponseBody'
     *   curl -X GET -iv http://localhost:8080/normal/string-without-response-body
     */
    @RequestMapping("/normal/string-without-response-body")
    public String normalStringWithoutResponseBody() {
        return "normalStringWithoutResponseBody";
    }
}
