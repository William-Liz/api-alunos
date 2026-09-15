package com.liz.api_alunos.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AlunoRequest {

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 50, message = "no máximo 50 caracteres")
    private String nome;

    @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Formato de email inválido")
    @Size(min = 5, max = 100, message = "Número de caracteres deve ser maior do que 5 e menor que 100")
    private String email;

    @NotBlank(message = "Senha não pode ser vazia")
    @Size(min = 5, max = 50, message = "Senha deve ter no mínimo 5 caracteres e no máximo 50")
    private String senha;

    @NotNull(message = "data de nascimento não pode ser vazio")
    @PastOrPresent(message = "data invalida")
    private LocalDate dataNascimento;

    @NotNull(message = "media não pode ser vazia")
    @Min(value = 0,message = "nota mínima é 0")
    @Max(value = 10,message = "nota máxima é 10")
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
