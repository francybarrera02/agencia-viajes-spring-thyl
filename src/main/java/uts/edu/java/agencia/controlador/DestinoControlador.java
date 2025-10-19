package uts.edu.java.agencia.controlador;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uts.edu.java.agencia.modelo.Destino;
import uts.edu.java.agencia.servicio.DestinoServicio;

@Controller
@RequestMapping("/views/destinos")
public class DestinoControlador {

	@Autowired
    private DestinoServicio destinoServicio;
	
	@GetMapping("/")
    public String listarDestinos(Model model) {
        model.addAttribute("titulo", "Lista de Destinos");
        model.addAttribute("listaDestinos", destinoServicio.listarDestinos());
        return "views/destinos/destinos";
    }
	
	@GetMapping("/nuevo")
    public String nuevoDestino(Model model) {
        model.addAttribute("titulo", "Nuevo Destino");
        model.addAttribute("destino", new Destino());
        return "views/destinos/nuevo_destino";
    }
		
	@PostMapping("/guardar")
	public String guardarDestino(@ModelAttribute("destino") Destino destino) {
	    if (destino.getId() == null || destino.getId().trim().isEmpty()) {
	        destino.setId(UUID.randomUUID().toString());
	    }
	    destinoServicio.guardarDestino(destino);
	    return "redirect:/views/destinos/";
	}
	
    @GetMapping("/editar/{id}")
    public String editarDestino(@PathVariable("id") String id, Model model) {
        Destino destino = destinoServicio.obtenerPorId(id);
        if (destino == null) {
            return "redirect:/views/destinos/";
        }
        model.addAttribute("titulo", "Editar Destino");
        model.addAttribute("destino", destino);
        return "views/destinos/editar_destino";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarDestino(@PathVariable("id") String id) {
        destinoServicio.eliminarDestino(id);
        return "redirect:/views/destinos/";
    }

	

}
