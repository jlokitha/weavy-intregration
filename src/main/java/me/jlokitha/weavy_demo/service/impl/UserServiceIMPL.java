package me.jlokitha.weavy_demo.service.impl;

import lombok.RequiredArgsConstructor;
import me.jlokitha.weavy_demo.service.UserService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * -----------------------------------------------------------------------------
 * Author    : Janindu Lokitha
 * Created   : 04/04/2025
 * Portfolio : https://jlokitha.me/
 * GitHub    : https://github.com/jlokitha
 * -----------------------------------------------------------------------------
 * Description: [Brief description of this file’s purpose.]
 */

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    @Autowired
    private final OkHttpClient httpClient;
    private final String baseUrl = "https://8015b5dbc0724d38882ac90397c27649.weavy.io/api/users";
    private final String apiToken = "wys_hMWpXdekxcn9Gc8Ioah3azOllzUZ7l3HN9yB";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    public String createUser(String jsonPayload) throws IOException {
        RequestBody body = RequestBody.create(jsonPayload, JSON);
        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiToken)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public String listUsers() throws IOException {
        return "";
    }

    @Override
    public String getUserDetails(String userId) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl + "/" + userId)
                .get()
                .addHeader("Authorization", "Bearer " + apiToken)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public String updateUser(String userId, String jsonPayload) throws IOException {
        return "";
    }

    @Override
    public String deleteUser(String userId) throws IOException {
        return "";
    }
}
