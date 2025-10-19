package uts.edu.java.agencia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="destinos")
public class Destino {
	
	@Id
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    private String nombre;
    private String pais;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
	public Destino() {
	}

	public Destino(String id, String nombre, String pais, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}
