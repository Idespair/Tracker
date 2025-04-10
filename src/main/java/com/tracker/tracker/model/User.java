package com.tracker.tracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String email;

    private String username;

    private String role;

    @DocumentReference
    private List<String> tasksIDs;
}
