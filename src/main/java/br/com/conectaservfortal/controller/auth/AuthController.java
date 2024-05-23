package br.com.conectaservfortal.controller.auth;

import br.com.conectaservfortal.config.TokenService;
import br.com.conectaservfortal.controller.auth.dto.LoginRequest;
import br.com.conectaservfortal.controller.auth.dto.LoginResponse;
import br.com.conectaservfortal.controller.auth.dto.UsuarioDto;
import br.com.conectaservfortal.model.Usuario;
import br.com.conectaservfortal.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    @Value("${jwt.expiration}")
    private Long expiresIn;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {

        var user = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        var auth = this.authenticationManager.authenticate(user);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token, expiresIn));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UsuarioDto data) {
        if (this.userRepository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario(data.name(), data.username(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
