package com.example.api.dto;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String nome;
    private String email;
    private String senhaHash;
    private LocalDateTime criadoEm;


    //constructor
    public User() {
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

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSenhaHash(String senhaHash){
        this.senhaHash = senhaHash;
    }
    public void setCriadoEm(LocalDateTime criadoEm){
        this.criadoEm = criadoEm;
    }
}
