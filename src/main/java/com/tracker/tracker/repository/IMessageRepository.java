package com.tracker.tracker.repository;

import com.tracker.tracker.model.Message;
import com.tracker.tracker.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface IMessageRepository extends ReactiveMongoRepository<Message, String> {

    Flux<Message> findMessageBySender(User user);

    Flux<Message> findByDateInBetween(LocalDateTime start, LocalDateTime end);

}
