package uts.edu.java.agencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uts.edu.java.agencia.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{

}
