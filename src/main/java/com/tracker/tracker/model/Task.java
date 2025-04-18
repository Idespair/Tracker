package com.tracker.tracker.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task")
public class Task {
    @Id
    private String id;

    private String title;

    private String content;

    @CreatedDate
    private LocalDateTime creationDate;

    private LocalDateTime deadline;

    @DocumentReference
    private List<User> users;

    @DocumentReference
    private List<ChatRoom> chatRooms;
}
