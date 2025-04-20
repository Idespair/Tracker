package com.tracker.tracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TaskDTO {

    private String id;

    private String title;

    private String content;

    private LocalDateTime creationDate;

    private LocalDateTime deadline;

}
