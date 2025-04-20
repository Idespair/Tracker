package com.tracker.tracker.service;

import com.tracker.tracker.dtos.TaskDTO;
import com.tracker.tracker.model.Task;
import com.tracker.tracker.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository iTaskRepository;

    public Mono<TaskDTO> getTaskByTitle (String title){
        return iTaskRepository.findTaskByTitle(title)
                .switchIfEmpty(Mono.error(new RuntimeException("No task found with title: "+ title)))
                .map(this::taskToDto);
    }

    public Flux<TaskDTO> getTaskByCreationDate (LocalDateTime date){
        return iTaskRepository.findTaskByCreationDate(date)
                .switchIfEmpty(Mono.error(new RuntimeException("No date")))
                .map(this::taskToDto);
    }

    public Flux<TaskDTO> getByCreationDateBetween(LocalDateTime start, LocalDateTime end){
        return iTaskRepository.findByCreationDateBetween(start, end)
                .switchIfEmpty(Mono.error(new RuntimeException("No date")))
                .map(this::taskToDto);
    }

    public Flux<TaskDTO> getTaskByDeadline (LocalDateTime date){
        return iTaskRepository.findTaskByDeadline(date)
                .switchIfEmpty(Mono.error(new RuntimeException("No date")))
                .map(this::taskToDto);
    }

    private TaskDTO taskToDto (Task task) {
        return new TaskDTO(task.getId(), task.getTitle(), task.getContent(), task.getDeadline(), task.getCreationDate());
    }

}
