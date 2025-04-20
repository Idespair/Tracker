package com.tracker.tracker.dtos;

import com.tracker.tracker.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MessageDTO {

    private String id;

    private String content;

    private User sender;

    private LocalDateTime sentTime;
}
