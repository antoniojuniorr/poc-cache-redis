package io.github.antoniojuniorr.poccacheredis.repository;


import io.github.antoniojuniorr.poccacheredis.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
