package com.example.api.dto;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String nome;
    private String email;
    private String senhaHash;
    private LocalDateTime criadoEm;


    //constructor
    public User(int id, String nome, String email, String senhaHash, LocalDateTime criadoEm){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
        this.criadoEm = criadoEm;
    }

    //getters
    public String getNome(){
        return this.nome;
    }
    public int getId(){
        return this.id;
    }
    public String getEmail(){
        return this.email;
    }
    public String getSenhaHash(){
        return this.senhaHash;
    }

}
