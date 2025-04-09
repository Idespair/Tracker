package com.tracker.tracker.repository;

import com.tracker.tracker.model.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends ReactiveMongoRepository<Task, String> {
}
