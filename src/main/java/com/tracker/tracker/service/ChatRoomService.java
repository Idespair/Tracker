package com.tracker.tracker.service;

import com.tracker.tracker.dtos.ChatRoomDTO;
import com.tracker.tracker.exceptions.InvalidChatRoomException;
import com.tracker.tracker.model.ChatRoom;
import com.tracker.tracker.repository.IChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ChatRoomService {

    @Autowired
    private IChatRoomRepository iChatRoomRepository;

    public Mono<ChatRoomDTO> getChatRoomByTitle (String title){
        return iChatRoomRepository.findChatRoomByTitle(title)
                .switchIfEmpty(Mono.error(new RuntimeException("No chat room named: " + title)))
                .map(this::chatRoomToDTO);
    }

    public Flux<ChatRoomDTO> getChatRoomByNumberOfUsersBetween(int min, int max){
        return iChatRoomRepository.findByNumberOfUsersBetween(min, max)
                .switchIfEmpty(Flux.error(new RuntimeException("No room found with the specified amount")))
                .map(this::chatRoomToDTO);
    }

    public Mono<ChatRoomDTO> createNewRoom (ChatRoom chatRoom){

        if (chatRoom.getNumberOfUsers() > 20) {
            return Mono.error(new InvalidChatRoomException("Number of users beyond current limits"));
        }

        if (chatRoom.getNumberOfUsers() <= 1) {
            return Mono.error(new InvalidChatRoomException("Not enough users to create a room"));
        }

        return iChatRoomRepository.save(chatRoom)
                .map(this::chatRoomToDTO);
    }

    private ChatRoomDTO chatRoomToDTO (ChatRoom chatRoom){
        return new ChatRoomDTO(chatRoom.getId(), chatRoom.getTitle(), chatRoom.getNumberOfUsers());
    }
}
