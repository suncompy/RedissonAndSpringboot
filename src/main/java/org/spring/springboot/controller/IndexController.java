package org.spring.springboot.controller;

import org.spring.springboot.annotation.MyLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sam
 * @since 2017/7/13
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @MyLog(requestUrl = "/index请求")
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}