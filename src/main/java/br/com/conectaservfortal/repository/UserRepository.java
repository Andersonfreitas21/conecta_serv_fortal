package br.com.conectaservfortal.repository;

import br.com.conectaservfortal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
}
