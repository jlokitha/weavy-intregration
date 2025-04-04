package me.jlokitha.weavy_demo.controller;

import me.jlokitha.weavy_demo.service.UserService;
import me.jlokitha.weavy_demo.service.impl.UserServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceIMPL userServiceIMPL) {
        this.userService = userServiceIMPL;
    }

    // Create User
    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody String jsonPayload) {
        try {
            String response = userService.createUser(jsonPayload);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating user: " + e.getMessage());
        }
    }
}
