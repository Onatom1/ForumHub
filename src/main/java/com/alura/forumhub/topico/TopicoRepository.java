package com.alura.forumhub.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Busca os 10 primeiros tópicos ordenados pela data de criação em ordem ascendente
    List<Topico> findTop10ByOrderByDataCriacaoAsc();

    // Busca tópicos por nome de curso e ano específico
    @Query("SELECT t FROM Topico t WHERE t.curso = :curso AND YEAR(t.dataCriacao) = :ano")
    List<Topico> findByCursoAndAno(@Param("curso") String curso, @Param("ano") int ano);
}
