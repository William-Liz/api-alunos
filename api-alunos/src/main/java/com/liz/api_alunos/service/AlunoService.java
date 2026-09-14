package com.liz.api_alunos.service;

import com.liz.api_alunos.dto.AlunoRequest;
import com.liz.api_alunos.dto.AlunoResponse;
import com.liz.api_alunos.model.Aluno;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private final List<Aluno> alunos;

    private int id = 1;

    public AlunoService() {
        alunos = new ArrayList<>();

    }

    public List<AlunoResponse> listarAlunos() {
        List<Aluno> alunosModel = alunos;
        List<AlunoResponse> alunosResponse = new ArrayList<>();
        for (Aluno aluno : alunosModel) {
            alunosResponse.add(new AlunoResponse(aluno.getId(), aluno.getNome(),
                    aluno.getEmail(), aluno.getDataNascimento(),aluno.getMedia()));
        }
        return alunosResponse;
    }
    public AlunoResponse obterPorId(int id) {
        for (Aluno a : alunos) {
            if (a.getId() == id){
                return new
                        AlunoResponse(a.getId(), a.getNome(), a.getEmail(), a.getDataNascimento(), a.getMedia());
            }
        }
        return null;
    }
    public void cadastrarAluno(AlunoRequest request) {
        alunos.add(new Aluno(id,
                request.getNome(),
                request.getEmail(),
                request.getSenha(),
                request.getDataNascimento(),
                request.getMedia()));
        id++;
    }
}
