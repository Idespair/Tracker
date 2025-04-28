package com.tracker.tracker.service;

import com.tracker.tracker.dtos.UserDTO;
import com.tracker.tracker.exceptions.InvalidUserException;
import com.tracker.tracker.model.User;
import com.tracker.tracker.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public Mono<UserDTO> getUserByEmail(String email){
        return iUserRepository.findByEmail(email)
                .switchIfEmpty(Mono.error(new InvalidUserException("No user found with email: " + email)))
                .map(this::toUserDTO);
    }

    public Flux<UserDTO> getAllByCertainName(String name){
        return iUserRepository.findAllByCertainName(name)
                .switchIfEmpty(Flux.error(new InvalidUserException("No user found with name: " + name)))
                .map(this::toUserDTO);
    }

    public Flux<UserDTO> getAllByAssignedTasks(String taskId){
        return iUserRepository.findAllByAssignedTask(taskId)
                .switchIfEmpty(Flux.error(new InvalidUserException("No tasks found with the ID: " + taskId)))
                .map(this::toUserDTO);
    }

    public Flux<UserDTO> findAllByRole(String role){
        return iUserRepository.findAllByCertainRole(role)
                .switchIfEmpty(Flux.error(new InvalidUserException("No user found with role: " + role)))
                .map(this::toUserDTO);
    }

    public Mono<User> deleteUserByName(String name){
        return  iUserRepository.findByName(name)
                .switchIfEmpty(Mono.error(new InvalidUserException("No user found with name: " + name)))
                .flatMap(user -> iUserRepository.delete(user).thenReturn(user));
    }


    // Need to create password cryptography logic
    public Mono<UserDTO> createNewUser(User user){

        if (user.getId() != null){
            return Mono.error(new InvalidUserException("User must not have any ID before creation"));
        }

        if (user.getName() == null || user.getName().isBlank()){
            return Mono.error(new InvalidUserException("User must have a name"));
        }

        if (user.getEmail() == null || user.getEmail().isBlank()){
            return Mono.error(new InvalidUserException("User must have an email"));
        }

        if (user.getPassword() == null || user.getPassword().isBlank()){
            return Mono.error(new InvalidUserException("User must have a valid password"));
        }

        return iUserRepository.save(user)
                .map(this::toUserDTO);
    }

    private UserDTO toUserDTO (User user){
        return new UserDTO(user.getId(), user.getName(), user.getRole(), user.getEmail());
    }
}
