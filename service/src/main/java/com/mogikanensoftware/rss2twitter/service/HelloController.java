package com.mogikanensoftware.rss2twitter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mogikanensoftware.rss2twitter.service.rss.Feed;
import com.mogikanensoftware.rss2twitter.service.rss.FeedParser;

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

    @GetMapping(path = "/rss/vogella")
    public Feed rssVogella() throws JsonProcessingException {

        return new FeedParser("http://www.vogella.com/article.rss").readFeed();
    }

    @GetMapping(path = "/rss/radiot")
    public Feed rssRadiot() throws JsonProcessingException {

        return new FeedParser("http://feeds.rucast.net/radio-t").readFeed();
    }

    @GetMapping(path = "/rss/jcg")
    public Feed rssJCG() throws JsonProcessingException {

        return new FeedParser("http://feeds.feedburner.com/JavaCodeGeeks").readFeed();
    }
}