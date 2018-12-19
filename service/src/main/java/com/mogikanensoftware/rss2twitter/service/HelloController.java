package com.mogikanensoftware.rss2twitter.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mogikanen9
 */

@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hi, there!";
    }
}