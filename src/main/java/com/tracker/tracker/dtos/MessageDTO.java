package com.tracker.tracker.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {

    private String id;

    private String content;

    private UserDTO sender;

    private LocalDateTime sentTime;
}
