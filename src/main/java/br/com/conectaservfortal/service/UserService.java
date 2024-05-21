package br.com.conectaservfortal.service;

import br.com.conectaservfortal.controller.dto.UsuarioDto;
import br.com.conectaservfortal.model.Usuario;

import java.util.List;

public interface UserService {
    void createUser(UsuarioDto dto);

    List<Usuario> findAll();
}
