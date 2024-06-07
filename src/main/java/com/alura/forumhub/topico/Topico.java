package com.alura.forumhub.topico;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private Date dataCriacao;
    private EstadoTopico estado;
    private String autor;
    private String curso;

    // Construtor vazio
    public Topico() {
    }

    // Construtor com todos os atributos
    public Topico(String titulo, String mensagem, Date dataCriacao, EstadoTopico estado, String autor, String curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.estado = estado;
        this.autor = autor;
        this.curso = curso;
    }

    // Getters e setters
    // ID
    public Long getId() {
        return id;
    }

    // Título
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Mensagem
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    // Data de criação
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Estado do tópico
    public EstadoTopico getEstado() {
        return estado;
    }

    public void setEstado(EstadoTopico estado) {
        this.estado = estado;
    }

    // Autor
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Curso
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
