package com.tracker.tracker.controller;

import com.tracker.tracker.repository.IChatRoomRepository;
import com.tracker.tracker.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    /* Implement controller functions*/
}
