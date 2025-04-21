package com.tracker.tracker.repository;

import com.tracker.tracker.model.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface ITaskRepository extends ReactiveMongoRepository<Task, String> {

    Mono<Task> findTaskByTitle(String title);

    Flux<Task> findTaskByCreationDate(LocalDateTime date);

    Flux<Task> findByCreationDateBetween(LocalDateTime start, LocalDateTime end);

    Flux<Task> findTaskByDeadline(LocalDateTime deadline);

    Flux<Task> findTaskByOpenedTasks(Boolean isOpen);
}
