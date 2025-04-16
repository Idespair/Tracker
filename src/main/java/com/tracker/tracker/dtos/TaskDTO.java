package com.tracker.tracker.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    private String id;

    private String title;

    private String content;

    private LocalDateTime deadline;

}
