package uts.edu.java.agencia.servicio;

import java.util.List;

import uts.edu.java.agencia.modelo.Paquete;

public interface IPaqueteServicio {
	
	List<Paquete> listartodo();
	
	Paquete buscarId(Integer id);
	
    Paquete guardarPaquete(Paquete paquete);
    
    void eliminarPaquete(Integer id);

 

}
