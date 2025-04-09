package com.tracker.tracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "task")
public class Task {
    @Id
    private String id;

    private String title;

    private String content;

    private LocalDateTime creationDate;

    private LocalDateTime deadline;

    private List<String> usersIDs;
}
