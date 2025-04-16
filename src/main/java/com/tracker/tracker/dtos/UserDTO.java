package com.tracker.tracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private String id;

    private String name;

    private String role;

    private String email;
}
