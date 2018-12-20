package com.mogikanensoftware.rss2twitter.service.twitter;

public interface TwitterPublisher {

    void updateStatus(String newStatus) throws PublisherException;

}