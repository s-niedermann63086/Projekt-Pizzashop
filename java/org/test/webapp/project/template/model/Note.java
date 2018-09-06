package org.test.webapp.project.template.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A note
 *
 * @author wap
 * @since 02.07.2018
 */
public class Note {

    private final static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LocalDateTime timestamp;
    private String text;

    public Note(String text) {
        this.timestamp = LocalDateTime.now();
        this.text = text != null ? text.trim() : "-";
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getFormattedTimestamp() {
        return timestamp.format(DATE_TIME_FORMAT);
    }

    public String getText() {
        return text;
    }
}
