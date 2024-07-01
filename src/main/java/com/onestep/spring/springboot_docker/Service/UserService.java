package com.onestep.spring.springboot_docker.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestep.spring.springboot_docker.DTO.UserDTO;
import com.onestep.spring.springboot_docker.Entity.User;
import com.onestep.spring.springboot_docker.Repository.UserRepo;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    
    public UserDTO createAccount(UserDTO userDTO){
        if(userDTO == null) return null;

        User user = convertUser(userDTO);
        userRepository.save(user);
        
        return userDTO;
    }

    public UserDTO changePassword(UserDTO userDTO){
        User user = userRepository.findById(userDTO.getId()).get();
        if (userDTO == null) 
            return null;
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;
    }

    private User convertUser (UserDTO account){
        User user = new User();
        user.setId(account.getId());
        user.setPhoneNumber(account.getPhoneNumber());
        user.setFirstName(account.getFirstName());
        user.setLastName(account.getLastName());
        user.setPassword(account.getPassword());
        return user;
    }

    private UserDTO convUserDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (User user : users) {
            UserDTO dto = convUserDTO(user);
            result.add(dto);
        }
        return result; 
    }

    public UserDTO findById(Long userId) {
        return convUserDTO(userRepository.findById(userId).get());
    }

}