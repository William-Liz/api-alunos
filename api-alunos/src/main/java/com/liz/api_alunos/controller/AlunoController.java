package com.liz.api_alunos.controller;

import com.liz.api_alunos.dto.AlunoResponse;
import com.liz.api_alunos.service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AlunoResponse> listarAlunos() {
        return  service.listarAlunos();
    }

    @GetMapping("/{id}")
    public AlunoResponse obterAlunoPorId(@PathVariable int id) {
        return service.obterPorId(id);
    }
}
