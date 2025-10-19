package uts.edu.java.agencia.servicio;

import java.util.List;

import uts.edu.java.agencia.modelo.Destino;


public interface IDestinoServicio {
	
    // Listar todos los destinos
    List<Destino> listarDestinos();

    // Buscar destino por ID
    Destino obtenerPorId(String id);

    // Guardar o actualizar un destino
    Destino guardarDestino(Destino destino);

    // Eliminar destino por ID
    void eliminarDestino(String id);

}
