package com.example.api.dto;

public class CreateUserRequest {
    private String nome;
    private String email;
    private String senha;

    public String getNome()  { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }

}
