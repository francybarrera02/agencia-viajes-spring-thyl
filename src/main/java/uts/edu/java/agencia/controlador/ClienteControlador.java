package uts.edu.java.agencia.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uts.edu.java.agencia.modelo.Cliente;
import uts.edu.java.agencia.modelo.Usuario;
import uts.edu.java.agencia.servicio.ClienteServicio;
import uts.edu.java.agencia.servicio.UsuarioServicio;

@Controller
@RequestMapping("/views/clientes")
public class ClienteControlador {


    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

	 @RequestMapping("/")
	 public String verCliente(Model model) {
		 List<Cliente> listaCliente= clienteServicio.lista();
		 model.addAttribute("listaCliente",listaCliente);
	        return "views/clientes/clientes";
		 
	 }
	 
	 @RequestMapping("/nuevo")
	 public String nuevoCliente (Model model) {
		 Cliente cliente =new Cliente();
		 List<Usuario>listarUsuarios=usuarioServicio.listar();
		 model.addAttribute("listarUsuarios", listarUsuarios);
		 model.addAttribute("cliente", cliente);
		 return "views/clientes/nuevo_cliente";
	 }
	
	    @PostMapping("/guardar")
	    public String guardar(@ModelAttribute Cliente cliente) {
	        clienteServicio.guardarCliente(cliente);
	        return "redirect:/views/clientes/";
	    }
	    
	   @GetMapping("/editar/{id}")
	    public String editar(@PathVariable("id") String id, Model model) {

	        // Obtener el cliente por su ID
	        Cliente cliente = clienteServicio.obtenerPorId(id);

	        // Obtener lista de usuarios para el select
	        List<Usuario> listarUsuarios = usuarioServicio.listar();

	        // Agregar datos al modelo
	        model.addAttribute("titulo", "Editar Cliente");
	        model.addAttribute("cliente", cliente);
	        model.addAttribute("listarUsuarios", listarUsuarios);

	        // Retornar la vista
	        return "views/clientes/editar_cliente";

}
	    @GetMapping("/eliminar/{id}")
	    public String eliminar(@PathVariable("id") String id) {
	        clienteServicio.eliminarCliente(id);
	        return "redirect:/views/clientes/";
	    }
	    

}