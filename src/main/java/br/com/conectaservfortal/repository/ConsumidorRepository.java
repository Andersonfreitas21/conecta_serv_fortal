package br.com.conectaservfortal.repository;

import br.com.conectaservfortal.model.consumidor.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Integer> {

    boolean existsByUsername(String username);
}
