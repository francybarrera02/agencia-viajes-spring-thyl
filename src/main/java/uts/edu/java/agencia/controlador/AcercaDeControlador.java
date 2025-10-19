package uts.edu.java.agencia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcercaDeControlador {
	
    @GetMapping("/views/acercade")
    public String mostrarAcercaDe(Model model) {
        model.addAttribute("titulo", "Acerca de la Agencia");
        return "views/acercade/acercade";
    }

}
