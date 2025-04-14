package com.tracker.tracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "message")
public class Message {
    @Id
    private String id;

    private User sender;

    private ChatRoom chatRoom;

    private String content;

    private LocalDateTime sentTime;

}
