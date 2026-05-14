package com.example.api.controller;
import com.example.api.dto.CreateUserRequest;
import com.example.api.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class userController {

    private Map<Integer, UserResponse> banco = new HashMap<>();
    private int proximoId = 1;


    @PostMapping
    public ResponseEntity<UserResponse> criar(@RequestBody CreateUserRequest req) {
        UserResponse user = new UserResponse(proximoId++, req.getNome(), req.getEmail());
        banco.put(user.getId(), user);
        return ResponseEntity.status(201).body(user);
   }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> buscar(@PathVariable int id) {
        UserResponse user = banco.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (banco.remove(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> atualizar(
            @PathVariable int id,
            @RequestBody CreateUserRequest req) {
        if (!banco.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        UserResponse atualizado = new UserResponse(id, req.getNome(), req.getEmail());
        banco.put(id, atualizado);
        return ResponseEntity.ok(atualizado);
    }
}