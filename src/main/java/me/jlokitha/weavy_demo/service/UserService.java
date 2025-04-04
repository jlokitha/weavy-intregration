package me.jlokitha.weavy_demo.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface UserService {
    String createUser(String jsonPayload) throws IOException;
    String listUsers(int take) throws IOException;
    String getUserDetails(String userId) throws IOException;
    String updateUser(String userId, String jsonPayload) throws IOException;
    String deleteUser(String userId) throws IOException;
}
