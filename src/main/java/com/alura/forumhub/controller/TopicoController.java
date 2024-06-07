package com.alura.forumhub.controller;

import com.alura.forumhub.topico.Topico;
import com.alura.forumhub.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> listarTodos() {
        return topicoRepository.findTop10ByOrderByDataCriacaoAsc();
    }

    @PostMapping
    public Topico criarTopico(@RequestBody Topico topico) {
        return topicoRepository.save(topico);
    }

    @GetMapping("/{id}")
    public Topico buscarPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado: " + id));
    }

    @PutMapping("/{id}")
    public Topico atualizarTopico(@PathVariable Long id, @RequestBody Topico topicoAtualizado) {
        return topicoRepository.findById(id)
                .map(topico -> {
                    topico.setTitulo(topicoAtualizado.getTitulo());
                    topico.setMensagem(topicoAtualizado.getMensagem());
                    topico.setDataCriacao(topicoAtualizado.getDataCriacao());
                    topico.setEstado(topicoAtualizado.getEstado());
                    topico.setAutor(topicoAtualizado.getAutor());
                    topico.setCurso(topicoAtualizado.getCurso());
                    return topicoRepository.save(topico);
                })
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado: " + id));
    }

    @DeleteMapping("/{id}")
    public void deletarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Tópico não encontrado: " + id);
        }
    }

    @GetMapping("/busca")
    public List<Topico> buscarPorCursoEAno(
            @RequestParam String curso,
            @RequestParam int ano) {
        return topicoRepository.findByCursoAndAno(curso, ano);
    }
}
