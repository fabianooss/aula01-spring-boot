package org.senac.aula01.repository;

import org.senac.aula01.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("select c from Carro c inner join fetch c.marca ")
    List<Carro> findAllWithMarca();
}
