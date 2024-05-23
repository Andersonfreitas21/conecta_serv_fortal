package br.com.conectaservfortal.controller.auth.dto;

import br.com.conectaservfortal.model.Usuario;

public record UsuarioDto(String name, String username, String password, Usuario.Role role) {
}
