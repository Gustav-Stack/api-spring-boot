package com.example.api.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class userController {
private Map<Integer, String> usuarios = new HashMap();

private int nextId = 0;

    @GetMapping
    public Map<Integer, String> list() {
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
    public String addUser(@RequestParam String name){
        usuarios.put(nextId++, name);
        return "Usuario"+name+":"+(nextId-1) +" com sucesso";
    }
}
