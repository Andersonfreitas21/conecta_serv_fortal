package br.com.conectaservfortal.controller;

import br.com.conectaservfortal.controller.dto.UsuarioDto;
import br.com.conectaservfortal.model.Usuario;
import br.com.conectaservfortal.service.impl.UserDetailsServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserDetailsServiceImpl userDetailsService;

    public UserController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Transactional
    @PostMapping("/users")
    public ResponseEntity<Void> newUser(@RequestBody UsuarioDto dto) {
        userDetailsService.createUser(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> listUsers() {
        var users = userDetailsService.findAll();
        return ResponseEntity.ok(users);
    }
}
