package org.senac.aula01.repository;

import org.senac.aula01.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    List<Marca> findByNomeContainingOrderByIdDesc(String nome);

    //jpql
    @Query("select m from Marca m where nome = :nome order by m.id desc")
    List<Marca> findByMarcas(String nome);


}
