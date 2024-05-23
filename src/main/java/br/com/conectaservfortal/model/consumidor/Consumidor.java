package br.com.conectaservfortal.model.consumidor;

import br.com.conectaservfortal.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "td_consumidor")
public class Consumidor extends Usuario {
    private List<String> preferecias;
    public Consumidor(String name, String username, Tipo tipo, List<String> preferecias) {
        super(name, username, tipo);
        this.preferecias = preferecias;
    }
}
