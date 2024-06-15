package io.github.devandref.pucminastrabalho.pucminastrabalho.repository;


import io.github.devandref.pucminastrabalho.pucminastrabalho.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}