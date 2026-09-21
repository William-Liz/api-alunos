package com.liz.api_alunos.controller;

import com.liz.api_alunos.dto.AlunoRequest;
import com.liz.api_alunos.dto.AlunoResponse;
import com.liz.api_alunos.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarAlunos() {
        return  ResponseEntity.status(HttpStatus.OK).body(service.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> obterAlunoPorId(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrarAluno(@Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAluno(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizarAluno(@Valid @RequestBody AlunoRequest request, @PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAluno(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(@PathVariable int id) {
        service.excluirAluno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
