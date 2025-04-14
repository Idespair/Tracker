package com.tracker.tracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ChatRoom")
public class ChatRoom {

    @Id
    private String id;

    private String title;

    private int numberOfUsers;

    @DocumentReference
    private List<String> userIds;

    @DocumentReference
    private List<String> tasksIds;

    @DocumentReference
    private List<String> messagesIds;
}
