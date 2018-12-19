package com.mogikanensoftware.rss2twitter.service.rss;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mogikanen9
 */
public class FeedParserTest{

    private static final int EMPTY_VALUE = 0;

    private FeedParser sut;

    @BeforeEach
    public void setUp(){
        sut = new FeedParser("http://www.vogella.com/article.rss");
    }

    @AfterEach
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testRead(){
        Feed feed = sut.readFeed();
        Assertions.assertNotNull(feed);
        Assertions.assertNotEquals(EMPTY_VALUE, feed.getEntries().size());
    }
}