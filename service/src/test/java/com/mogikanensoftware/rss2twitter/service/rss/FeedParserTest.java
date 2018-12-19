package com.mogikanensoftware.rss2twitter.service.rss;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mogikanen9
 */
public class FeedParserTest{

    private static final int EMPTY_VALUE = 0;

    private FeedParser sut;

    @Before
    public void setUp(){
        sut = new FeedParser("http://www.vogella.com/article.rss");
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test
    public void testRead(){
        Feed feed = sut.readFeed();
        Assert.assertNotNull(feed);
        Assert.assertThat(feed.getEntries().size(), CoreMatchers.not(EMPTY_VALUE));
    }
}