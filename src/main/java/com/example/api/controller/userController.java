package com.example.api.controller;


import com.example.api.dto.CreateUserRequest;
import com.example.api.dto.User;
import com.example.api.dto.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    private List<User> banco = new ArrayList<>();
    private int nextId = 1;

    @PostMapping()
    public UserResponse criar(@RequestBody CreateUserRequest req){

        User user = new User();

        user.setId(nextId++);
        user.setNome(req.getNome());
        user.setEmail(req.getEmail());
        user.setSenhaHash("hash_de_" + req.getSenha()); // simula hash
        user.setCriadoEm(LocalDateTime.now());
        banco.add(user);

        return new UserResponse(user.getId(), user.getNome(), user.getEmail());
    }
    @GetMapping
    public List<UserResponse> listar() {
        return banco.stream()
                .map(u -> new UserResponse(u.getId(), u.getNome(), u.getEmail()))
                .toList();
    }





}
