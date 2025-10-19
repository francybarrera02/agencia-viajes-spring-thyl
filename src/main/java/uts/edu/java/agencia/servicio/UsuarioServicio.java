package uts.edu.java.agencia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uts.edu.java.agencia.modelo.Usuario;
import uts.edu.java.agencia.repositorio.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicio implements IUsuarioServicio {

	@Autowired
    private UsuarioRepositorio usuarioRepositorio;

	
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
        return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario obtenerPorId(String id) {
		// TODO Auto-generated method stub
        return usuarioRepositorio.findById(id).orElse(null);
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		// TODO Auto-generated method stub
        return usuarioRepositorio.save(usuario);
	}

	@Override
	public void eliminar(String id) {
		// TODO Auto-generated method stub
        usuarioRepositorio.deleteById(id);

	}

	
}
