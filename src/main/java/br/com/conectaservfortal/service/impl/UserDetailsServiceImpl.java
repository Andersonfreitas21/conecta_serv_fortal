package br.com.conectaservfortal.service.impl;

import br.com.conectaservfortal.controller.dto.UsuarioDto;
import br.com.conectaservfortal.model.Role;
import br.com.conectaservfortal.model.Usuario;
import br.com.conectaservfortal.repository.RoleRepository;
import br.com.conectaservfortal.repository.UserRepository;
import br.com.conectaservfortal.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UsuarioDto dto) {
        var userFromDb = userRepository.findByUsername(dto.username());

        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = new Usuario();
        user.setName(dto.name());
        user.setUsername(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));

        var userRole = new Role();
        if (dto.tipo().equals(Usuario.Tipo.PRESTADOR_SERVICO)) {
            userRole.setName("PRESTADOR_SERVICO");
        } else {
            userRole.setName("CONTRATANTE");
        }
        roleRepository.save(userRole);

        user.getRoles().add(userRole);
        user.setTipo(dto.tipo());

        userRepository.save(user);
    }

    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

}
