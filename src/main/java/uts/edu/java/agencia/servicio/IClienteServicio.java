package uts.edu.java.agencia.servicio;

import java.util.List;

import uts.edu.java.agencia.modelo.Cliente;

public interface IClienteServicio {

	List<Cliente> lista();
    
    // Buscar cliente por ID
    Cliente obtenerPorId(String id);
    
    // Guardar o actualizar un cliente
    Cliente guardarCliente(Cliente cliente);
    
    // Eliminar cliente por ID
    void eliminarCliente(String id);
	
}
