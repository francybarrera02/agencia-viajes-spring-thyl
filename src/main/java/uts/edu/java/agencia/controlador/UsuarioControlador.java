package uts.edu.java.agencia.controlador;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uts.edu.java.agencia.modelo.Usuario;
import uts.edu.java.agencia.servicio.UsuarioServicio;

@Controller
@RequestMapping("/views/usuarios")
public class UsuarioControlador {

	 @Autowired
	 private UsuarioServicio usuarioServicio;
	 @RequestMapping("/")
	 public String verUsuario(Model model) {
		 List<Usuario> listarUsuarios= usuarioServicio.listar();
		 model.addAttribute("listarUsuarios",listarUsuarios);
	        return "views/usuarios/usuarios";

		 
	 }
	 
	    @GetMapping("/nuevo")
	    public String nuevoUsuario(Model model) {
	        model.addAttribute("titulo", "Nuevo Usuario");
	        model.addAttribute("usuario", new Usuario());
	        return "views/usuarios/nuevo_usuario";
	    }

	    
	    @PostMapping("/guardar")
	    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
	        if (usuario.getId() == null || usuario.getId().trim().isEmpty()) {
	            usuario.setId(UUID.randomUUID().toString());
	        }
	        usuarioServicio.guardar(usuario);
	        return "redirect:/views/usuarios/";
	    }
	    
	    
	    @GetMapping("/editar/{id}")
	    public String editarUsuario(@PathVariable("id") String id, Model model) {
	        Usuario usuario = usuarioServicio.obtenerPorId(id);
	        if (usuario == null) {
	            return "redirect:/views/usuarios/";
	        }
	        model.addAttribute("titulo", "Editar Usuario");
	        model.addAttribute("usuario", usuario);
	        return "views/usuarios/editar_usuario";
	    }
	    
	    @GetMapping("/eliminar/{id}")
	    public String eliminarUsuario(@PathVariable("id") String id) {
	        usuarioServicio.eliminar(id);
	        return "redirect:/views/usuarios/";
	    }
}