package com.tracker.tracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Message {
    @Id
    private String id;

    private String content;

    private LocalDateTime sentTime;

}
