package uts.edu.java.agencia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uts.edu.java.agencia.modelo.Destino;
import uts.edu.java.agencia.repositorio.DestinoRepositorio;

@Service
@Transactional

public class DestinoServicio implements IDestinoServicio{
	
	@Autowired
    private DestinoRepositorio destinoRepositorio;


	@Override
	public List<Destino> listarDestinos() {
		// TODO Auto-generated method stub
        return destinoRepositorio.findAll();
	}

	@Override
	public Destino obtenerPorId(String id) {
		// TODO Auto-generated method stub
        return destinoRepositorio.findById(id).orElse(null);
	}

	@Override
	public Destino guardarDestino(Destino destino) {
		// TODO Auto-generated method stub
        return destinoRepositorio.save(destino);
	}

	@Override
	public void eliminarDestino(String id) {
		// TODO Auto-generated method stub
        destinoRepositorio.deleteById(id);

	}

}
