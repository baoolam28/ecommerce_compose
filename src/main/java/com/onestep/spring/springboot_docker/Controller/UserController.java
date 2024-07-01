package com.onestep.spring.springboot_docker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onestep.spring.springboot_docker.DTO.UserDTO;
import com.onestep.spring.springboot_docker.Service.UserService;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<?> index() {
        List<UserDTO> response = userService.findAll();

        if (response != null)
            return ResponseEntity.ok().body(response);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUserById(@RequestParam("id") Long userId) {
        UserDTO response = userService.findById(userId);
        
        if(response!= null)
        return ResponseEntity.ok().body(response);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/registrations")
    public ResponseEntity<?> getRegistration(@RequestBody UserDTO userDTO) {

        UserDTO response = userService.createAccount(userDTO);

        if(response != null) 
            return ResponseEntity.ok().body(response);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
