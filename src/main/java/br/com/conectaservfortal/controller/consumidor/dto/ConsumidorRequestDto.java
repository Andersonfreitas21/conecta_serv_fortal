package br.com.conectaservfortal.controller.consumidor.dto;

import br.com.conectaservfortal.model.Usuario;

import java.util.List;

public record ConsumidorRequestDto(
        String name,
        String username,
        Usuario.Tipo tipo,
        List<String> preferecias
) {
}
