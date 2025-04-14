package com.tracker.tracker.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    public String id;

    public String title;

    public String content;

    public LocalDateTime deadline;

}
