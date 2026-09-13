package com.liz.api_alunos.service;

import com.liz.api_alunos.dto.AlunoResponse;
import com.liz.api_alunos.model.Aluno;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private final List<Aluno> alunos;

    public AlunoService() {
        alunos = new ArrayList<>();

        alunos.add(new Aluno(0,"William","w@email",
                "senha", LocalDate.of(1999,05,03),9));

        alunos.add(new Aluno(1,"yuri","y@email",
                "senha", LocalDate.of(2006,07,13),9));

        alunos.add(new Aluno(2,"Enzo","e@email",
                "senha", LocalDate.of(2008,12,06),9));
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
}
