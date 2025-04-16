package com.tracker.tracker.repository;

import com.tracker.tracker.model.ChatRoom;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IChatRoomRepository extends ReactiveMongoRepository<ChatRoom, String> {

    Mono<ChatRoom> findChatRoomByTitle(String title);

    Flux<ChatRoom> findByNumberOfUsersBetween(int min, int max);


}
