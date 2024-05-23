package br.com.conectaservfortal.service.impl;

import br.com.conectaservfortal.controller.consumidor.dto.ConsumidorRequestDto;
import br.com.conectaservfortal.model.consumidor.Consumidor;
import br.com.conectaservfortal.repository.ConsumidorRepository;
import br.com.conectaservfortal.service.ConsumidorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumidorServiceImpl implements ConsumidorService {
    private final ConsumidorRepository consumidorRepository;

    public ConsumidorServiceImpl(ConsumidorRepository consumidorRepository) {
        this.consumidorRepository = consumidorRepository;
    }

    @Override
    public List<Consumidor> findAll() {
        return consumidorRepository.findAll();
    }

    @Override
    public Optional<Consumidor> findById(Integer id) {
        return consumidorRepository.findById(id);
    }

    @Override
    public Consumidor save(ConsumidorRequestDto consumidor) {
        if (!consumidorRepository.existsByUsername(consumidor.username())) {
            Consumidor newConsumidor = new Consumidor();

            newConsumidor.setName(consumidor.name());
            newConsumidor.setUsername(consumidor.username());
            newConsumidor.setTipo(consumidor.tipo());
            newConsumidor.setPassword("");
            newConsumidor.setPreferecias(consumidor.preferecias());

            return consumidorRepository.save(newConsumidor);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        consumidorRepository.deleteById(id);
    }

    @Override
    public Consumidor update(Consumidor updatedConsumidor) {
        return consumidorRepository.save(updatedConsumidor);
    }
}
