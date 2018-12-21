package com.mogikanensoftware.rss2twitter.core.rss;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * @author mogikanen9
 */
public class FeedParserTest{
	
    private static final String RSS_FEED_VOGELLA = "http://www.vogella.com/article.rss";
    private static final String RSS_FEED_RADIOT = "http://feeds.rucast.net/radio-t";
    private static final String RSS_FEED_JGC = "http://feeds.feedburner.com/JavaCodeGeeks";
    

	private static final int EMPTY_VALUE = 0;

    private FeedParser sut;

    @BeforeEach
    public void setUp(){
        sut = new FeedParser(RSS_FEED_VOGELLA);
    }

    @AfterEach
    public void tearDown(){
        sut = null;
    }

    @ParameterizedTest
    @ValueSource(strings = { 
        RSS_FEED_VOGELLA, 
        RSS_FEED_RADIOT, 
        RSS_FEED_JGC })
    public void testRead(String rssUrl){
        Feed feed = new FeedParser(rssUrl).readFeed();
        Assertions.assertNotNull(feed);
        Assertions.assertNotEquals(EMPTY_VALUE, feed.getEntries().size());
    }
}