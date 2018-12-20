package com.mogikanensoftware.rss2twitter.core.rss;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mogikanen9
 */

@Data
@AllArgsConstructor
public class Feed {
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private String pubDate;

    private List<FeedMessage> entries;
}