package com.stonie.springnotes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingController {

    /**
     * curl -X GET -i http://localhost:8080/path-method-all
     * curl -X POST -i http://localhost:8080/path-method-all
     */
    @RequestMapping(path = "/path-method-all")
    public String pathMethodAll() {
        return "pathMethodAll";
    }

    /**
     * curl -X POST -i http://localhost:8080/path-method-post
     */
    @RequestMapping(path = "/path-method-post", method = RequestMethod.POST)
    public String pathMethodPost() {
        return "pathMethodPost";
    }

    /**
     * curl -X POST -H "key:value" -i http://localhost:8080/path-method-post-headers
     */
    @RequestMapping(path = "/path-method-post-headers", method = RequestMethod.POST, headers = "key=value")
    public String pathMethodPostHeaders() {
        return "pathMethodPostHeaders";
    }

    /**
     * curl -X POST -H "Content-Type:application/json" -i http://localhost:8080/path-method-post-consumes
     */
    @RequestMapping(path = "/path-method-post-consumes", method = RequestMethod.POST, consumes = "application/json")
    public String pathMethodPostConsumes() {
        return "pathMethodPostConsumes";
    }

    /**
     * curl -X POST -iv http://localhost:8080/path-method-post-produces
     *
     *  指定 HTTP 响应 Content-Type: application/json;charset=UTF-8
     *  如果不指定 produces，默认为 Content-Type: text/plain;charset=UTF-8
     */
    @RequestMapping(path = "/path-method-post-produces", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String pathMethodPostProduces() {
        return "pathMethodPostProduces";
    }

    /**
     * curl -X GET -i http://localhost:8080/path-a
     * curl -X GET -i http://localhost:8080/path-b
     */
    @RequestMapping(path = { "/path-a", "/path-b" }, method = RequestMethod.GET)
    public String pathMultiple() {
        return "pathMultiple";
    }

    /**
     * This is OK:
     *   curl -X POST -i http://localhost:8080/path-method-multiple
     *   curl -X PUT -i http://localhost:8080/path-method-multiple
     * This is not OK:
     *   curl -X GET -i http://localhost:8080/path-method-multiple
     */
    @RequestMapping(path = "/path-method-multiple", method = { RequestMethod.POST, RequestMethod.PUT })
    public String methodMultiple() {
        return "methodMultiple";
    }

    /**
     * curl -X GET -i http://localhost:8080/path-method-get/1
     */
    @RequestMapping(path = "/path-method-get/{id}", method = RequestMethod.GET)
    public String pathMethodGet(@PathVariable String id) {
        return "pathMethodGet: " + id;
    }

    /**
     * This is OK:
     *   curl -X GET -i http://localhost:8080/path-method-get-regex/123
     * This is not OK:
     *   curl -X GET -i http://localhost:8080/path-method-get-regex/hello
     */
    @RequestMapping(path = "/path-method-get-regex/{id:[\\d]+}", method = RequestMethod.GET)
    public String pathMethodGetRegex(@PathVariable String id) {
        return "pathMethodGetRegex: " + id;
    }

    /**
     * curl -X GET -i http://localhost:8080/path-method-get-param?id=1
     */
    @RequestMapping(path = "/path-method-get-param", method = RequestMethod.GET)
    public String pathMethodGetParam(@RequestParam String id) {
        return "pathMethodGetParam: " + id;
    }

    /**
     * curl -X GET -i http://localhost:8080/path-method-get-param-default
     * curl -X GET -i http://localhost:8080/path-method-get-param-default?id=5
     */
    @RequestMapping(path = "/path-method-get-param-default", method = RequestMethod.GET)
    public String pathMethodGetParamDefault(@RequestParam(defaultValue = "1") String id) {
        return "pathMethodGetParamDefault: " + id;
    }

    /**
     * This is OK:
     *   curl -X GET -i "http://localhost:8080/path-method-get-param-required?a=1"
     *   curl -X GET -i "http://localhost:8080/path-method-get-param-required?a=1&b=2"
     * This is not OK:
     *   curl -X GET -i "http://localhost:8080/path-method-get-param-required?b=2"
     */
    @RequestMapping(path = "/path-method-get-param-required", method = RequestMethod.GET)
    public String pathMethodGetParamRequired(
            @RequestParam String a, @RequestParam(required = false) String b) {
        return "pathMethodGetParamRequired: " + a + ", " + b;
    }

    /**
     * curl -X GET -i http://localhost:8080/path-method-get-simple
     */
    @GetMapping(path = "/path-method-get-simple")
    public String pathMethodGetSimple() {
        return "pathMethodGetSimple";
    }
}
