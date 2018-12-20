package com.mogikanensoftware.rss2twitter.core.twitter;

public interface TwitterPublisher {

    void updateStatus(String newStatus) throws PublisherException;

}