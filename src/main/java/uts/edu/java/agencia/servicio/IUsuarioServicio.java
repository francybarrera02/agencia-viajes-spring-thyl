package uts.edu.java.agencia.servicio;

import java.util.List;
import uts.edu.java.agencia.modelo.Usuario;

public interface IUsuarioServicio {

	// Listar todos los usuarios
    List<Usuario> listar();

    // Obtener un usuario por su ID
    Usuario obtenerPorId(String id);

    // Guardar o actualizar un usuario
    Usuario guardar(Usuario usuario);

    // Eliminar usuario por ID
    void eliminar(String id);
	
}
