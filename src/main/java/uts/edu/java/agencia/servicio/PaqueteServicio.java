package uts.edu.java.agencia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uts.edu.java.agencia.modelo.Paquete;
import uts.edu.java.agencia.repositorio.PaqueteRepositorio;

@Service
@Transactional
public class PaqueteServicio implements IPaqueteServicio{
	
	@Autowired
	private PaqueteRepositorio paqueteRepositorio;

	@Override
	public List<Paquete> listartodo() {
		// TODO Auto-generated method stub
		return paqueteRepositorio.findAll();
	}

	@Override
	public Paquete buscarId(Integer id) {
		// TODO Auto-generated method stub
		return paqueteRepositorio.findById(id).orElse(null);
	}

	@Override
	public Paquete guardarPaquete(Paquete paquete) {
		// TODO Auto-generated method stub
		return paqueteRepositorio.save(paquete);
	}

	@Override
	public void eliminarPaquete(Integer id) {
		// TODO Auto-generated method stub
		paqueteRepositorio.deleteById(id);
		
	}

}
