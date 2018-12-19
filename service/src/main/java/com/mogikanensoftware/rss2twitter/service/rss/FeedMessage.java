package com.mogikanensoftware.rss2twitter.service.rss;

import lombok.Data;

/**
 * @author mogikanen9
 */

@Data
public class FeedMessage {
    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;
}