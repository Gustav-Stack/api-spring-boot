package com.example.api.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class userController {
private List<String> usuarios = new ArrayList(
        List.of("Alice", "Bob", "Smith")
);

    @GetMapping
    public List<String> list() {
        return usuarios;
    }

    @GetMapping("{id}")
    public String findById(@PathVariable  int id) {
        if (id < 0 || id >= usuarios.size()) {
            return "Usuário não encontrado";
        }
        return usuarios.get(id);
    }


    @PostMapping()
    public List<String> addUser(@RequestParam String name){
        usuarios.add(name);
        return usuarios;
    };
}
