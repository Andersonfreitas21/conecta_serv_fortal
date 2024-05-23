package br.com.conectaservfortal.service;

import br.com.conectaservfortal.controller.consumidor.dto.ConsumidorRequestDto;
import br.com.conectaservfortal.model.consumidor.Consumidor;

import java.util.List;
import java.util.Optional;

public interface ConsumidorService {
    List<Consumidor> findAll();
    Optional<Consumidor> findById(Integer id);
    Consumidor save(ConsumidorRequestDto consumidor);
    void deleteById(Integer id);

    Consumidor update(Consumidor updatedConsumidor);
}
