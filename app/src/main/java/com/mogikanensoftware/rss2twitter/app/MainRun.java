package com.mogikanensoftware.rss2twitter.app;

import com.mogikanensoftware.rss2twitter.core.rss.FeedMessage;
import com.mogikanensoftware.rss2twitter.core.rss.FeedParser;
import com.mogikanensoftware.rss2twitter.core.twitter.Twitter4JPublisher;

public class MainRun {

        public static void main(String[] args) throws Exception {

                if (args.length < 4) {
                        throw new RuntimeException(String.format("Please, provdie all 4 params"));
                }

                String rssFeedUrl = args[0];
                String oathConsumerKey = args[1];
                String oathConsumerSecret = args[2];
                String oathAccessToken = args[3];
                String oathAccessTokenSecret = args[4];

                if (oathAccessToken == null) {
                        throw new RuntimeException(String.format("oathConsumerKey arg cannot be null"));
                }

                FeedMessage message = new FeedParser(rssFeedUrl).readFeed().getEntries()
                                .stream().findFirst().get();

                String newStatusValue = String.format("%s - %s", message.getTitle(), message.getLink());

                new Twitter4JPublisher(oathConsumerKey, oathConsumerSecret, oathAccessToken, oathAccessTokenSecret)
                                .updateStatus(newStatusValue);
        }
}