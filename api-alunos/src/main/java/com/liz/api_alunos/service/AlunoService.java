package com.liz.api_alunos.service;

import com.liz.api_alunos.dto.AlunoRequest;
import com.liz.api_alunos.dto.AlunoResponse;
import com.liz.api_alunos.exception.AlunoNaoEncontradoException;
import com.liz.api_alunos.exception.EmailJaCadastradoException;
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
        throw new AlunoNaoEncontradoException("Aluno não encontrado");
    }
    public AlunoResponse cadastrarAluno(AlunoRequest request) {
        for (Aluno aluno : alunos) {
            if (aluno.getEmail().equalsIgnoreCase(request.getEmail())) {
                throw new EmailJaCadastradoException("Email ja cadastrado: ");
            }
        }
        alunos.add(new Aluno(id,
                request.getNome(),
                request.getEmail(),
                request.getSenha(),
                request.getDataNascimento(),
                request.getMedia()));

        id++;

        Aluno alunoCadastro = alunos.get(alunos.size() - 1);

        return new AlunoResponse(alunoCadastro.getId(),
                alunoCadastro.getNome(),
                alunoCadastro.getEmail(),
                alunoCadastro.getDataNascimento(),
                alunoCadastro.getMedia());
    }
    public  AlunoResponse atualizarAluno(int id, AlunoRequest request) {
        for (Aluno a : alunos) {

            if (a.getEmail().equalsIgnoreCase(request.getEmail()) && id != a.getId()) {
                throw new EmailJaCadastradoException("Email ja cadastrado: ");
            }
            if (a.getId() == id){
                a.setNome(request.getNome());
                a.setEmail(request.getEmail());
                a.setSenha(request.getSenha());
                a.setDataNascimento(request.getDataNascimento());
                a.setMedia(request.getMedia());

                return new AlunoResponse(id, a.getNome(),
                        a.getEmail(),
                        a.getDataNascimento(),
                        a.getMedia());
            }
        }
        throw new AlunoNaoEncontradoException("Aluno não encontrado");
    }
    public void excluirAluno(int id) {
        for (Aluno a : alunos) {
            if (a.getId() == id){
                alunos.remove(a);
                return;
            }
        }
        throw new AlunoNaoEncontradoException("Aluno não encontrado");
    }
}
