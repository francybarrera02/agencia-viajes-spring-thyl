package uts.edu.java.agencia.servicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import uts.edu.java.agencia.modelo.Cliente;
import uts.edu.java.agencia.repositorio.ClienteRepositorio;

@Service
@Transactional
public class ClienteServicio implements IClienteServicio{
	
	@Autowired
    private ClienteRepositorio clienteRepositorio;

	@Override
	public List<Cliente> lista() {
		// TODO Auto-generated method stub
        return clienteRepositorio.findAll();
	}

	@Override
	public Cliente obtenerPorId(String id) {
		// TODO Auto-generated method stub
        return clienteRepositorio.findById(id).orElse(null);
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
        return clienteRepositorio.save(cliente);
	}

	@Override
	public void eliminarCliente(String id) {
		// TODO Auto-generated method stub
		clienteRepositorio.deleteById(id);

	}
	
	
}
