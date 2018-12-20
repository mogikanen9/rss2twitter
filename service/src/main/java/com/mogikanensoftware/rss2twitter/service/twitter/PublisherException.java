package com.mogikanensoftware.rss2twitter.service.twitter;

public class PublisherException extends Exception {

    private static final long serialVersionUID = 1L;

    public PublisherException(Exception ex){
        super(ex);
    }
}