package com.tracker.tracker.repository;

import com.tracker.tracker.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface IUserRepository extends ReactiveMongoRepository<User, String> {
    Flux<User> findAllByCertainName (String name);

    Mono<User> findByEmail(String email);

    Mono<Void> deleteByName(String name);

    Flux<User> findAllByAssignedTask(String taskId);

    Flux<User> findAllByCertainRole(String role);

    Mono<User> findByName(String name);
}
