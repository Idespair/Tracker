package com.tracker.tracker.service;

import com.tracker.tracker.dtos.MessageDTO;
import com.tracker.tracker.model.Message;
import com.tracker.tracker.model.User;
import com.tracker.tracker.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    private IMessageRepository iMessageRepository;

    public Flux<MessageDTO> getMessageBySender(User user){
        return iMessageRepository.findMessageBySender(user)
                .switchIfEmpty(Flux.error(new RuntimeException("No message found")))
                .map(this::messageToDTO);
    }

    public Flux<MessageDTO> getByDateInBetween(LocalDateTime start, LocalDateTime end){
        return  iMessageRepository.findByDateInBetween(start, end)
                .switchIfEmpty(Flux.error(new RuntimeException("No message found")))
                .map(this::messageToDTO);
    }

    private MessageDTO messageToDTO(Message message){
        return new MessageDTO(message.getId(), message.getContent(), message.getSender(), message.getSentTime());
    }

}
