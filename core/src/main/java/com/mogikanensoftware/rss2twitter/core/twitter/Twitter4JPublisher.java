package com.mogikanensoftware.rss2twitter.core.twitter;

import com.mogikanensoftware.rss2twitter.core.rss.FeedMessage;
import com.mogikanensoftware.rss2twitter.core.rss.FeedParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@AllArgsConstructor
public class Twitter4JPublisher implements TwitterPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Twitter4JPublisher.class);

    private String oathConsumerKey;
    private String oathConsumerSecret;
    private String oathAccessToken;
    private String oathAccessTokenSecret;

    public void updateStatus(String newStatus) throws PublisherException {

        try {

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(LOGGER.isDebugEnabled()).setOAuthConsumerKey(oathConsumerKey)
                    .setOAuthConsumerSecret(oathConsumerSecret).setOAuthAccessToken(oathAccessToken)
                    .setOAuthAccessTokenSecret(oathAccessTokenSecret);
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            Status status;

            status = twitter.updateStatus(newStatus);
            LOGGER.info(String.format("Successfully updated the status to [%s].", status.getText()));
        } catch (TwitterException e) {
            throw new PublisherException(e);
        }

    }

}