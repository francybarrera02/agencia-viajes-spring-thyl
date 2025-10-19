package uts.edu.java.agencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uts.edu.java.agencia.modelo.Cliente;


public interface ClienteRepositorio extends JpaRepository<Cliente, String>{

}
