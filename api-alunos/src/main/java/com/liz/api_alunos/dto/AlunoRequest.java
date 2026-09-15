package com.liz.api_alunos.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AlunoRequest {

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotBlank
    @Email
    @Size(min = 5, max = 100)
    private String email;

    @NotBlank
    @Size(min = 5, max = 50)
    private String senha;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @NotNull
    @Min(value = 0)
    @Max(value = 10)
    private double media;

    public AlunoRequest(String nome, String email, String senha, LocalDate dataNascimento, double media) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
