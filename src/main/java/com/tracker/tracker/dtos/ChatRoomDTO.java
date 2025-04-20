package com.tracker.tracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatRoomDTO {

    private String id;

    private String title;

    private int numberOfUsers;

}
