package br.com.conectaservfortal.controller.consumidor;

import br.com.conectaservfortal.controller.consumidor.dto.ConsumidorRequestDto;
import br.com.conectaservfortal.model.consumidor.Consumidor;
import br.com.conectaservfortal.service.ConsumidorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/consumidor")
public class ConsumidorController {
    private final ConsumidorService consumidorService;

    public ConsumidorController(ConsumidorService consumidorService) {
        this.consumidorService = consumidorService;
    }
    @GetMapping
    public List<Consumidor> getAllConsumidores() {
        return consumidorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumidor> getConsumidorById(@PathVariable Integer id) {
        Optional<Consumidor> consumidor = consumidorService.findById(id);
        return consumidor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Consumidor createConsumidor(@RequestBody ConsumidorRequestDto consumidor) {
        return consumidorService.save(consumidor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consumidor> updateConsumidor(@PathVariable Integer id, @RequestBody ConsumidorRequestDto consumidorDetails) {
        Optional<Consumidor> consumidor = consumidorService.findById(id);
        if (consumidor.isPresent()) {
            Consumidor updatedConsumidor = consumidor.get();
            updatedConsumidor.setName(consumidorDetails.name());
            updatedConsumidor.setPreferecias(consumidorDetails.preferecias());
            consumidorService.update(updatedConsumidor);
            return ResponseEntity.ok(updatedConsumidor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumidor(@PathVariable Integer id) {
        if (consumidorService.findById(id).isPresent()) {
            consumidorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
