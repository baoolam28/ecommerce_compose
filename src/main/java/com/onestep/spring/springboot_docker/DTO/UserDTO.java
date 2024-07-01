package com.onestep.spring.springboot_docker.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String password;
}
