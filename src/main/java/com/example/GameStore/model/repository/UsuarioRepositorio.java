package com.example.GameStore.model.repository;

import com.example.GameStore.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository implementa todos los métodos findALL, save, getById...
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

}
