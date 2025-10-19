package uts.edu.java.agencia.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import uts.edu.java.agencia.modelo.Paquete;
import uts.edu.java.agencia.servicio.PaqueteServicio;

@Controller
@RequestMapping("/views/paquetes")
public class PaqueteControlador {
	
	@Autowired
	private PaqueteServicio paqueteServicio;
	
	@GetMapping("/")
	public String listarPaquetes(Model model) {
		List<Paquete> listaPaquetes = paqueteServicio.listartodo();		
	    model.addAttribute("listaPaquetes", listaPaquetes);
	    return "views/paquetes/paquetes";
	}

}
