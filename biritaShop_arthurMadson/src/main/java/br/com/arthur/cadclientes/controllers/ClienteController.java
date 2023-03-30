package br.com.arthur.cadclientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.arthur.cadclientes.model.Cliente;
import br.com.arthur.cadclientes.repositories.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepo;

	ClienteController(ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

	@GetMapping
	public String index() {
		return "index.html";
	}

	@GetMapping("/listarClientes")
	public ModelAndView listarclientes() {
		List<Cliente> todasAsclientes = clienteRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarclientes");
		modelAndView.addObject("todasAsclientes", todasAsclientes);
		return modelAndView;
	}

	@GetMapping("/adicionarCliente")
	public ModelAndView formAdicionarcliente() {
		ModelAndView modelAndView = new ModelAndView("adicionarcliente");
		modelAndView.addObject(new Cliente());
		return modelAndView;
	}

	@PostMapping("/adicionarCliente")
	public String adicionarcliente(Cliente p) {
		this.clienteRepo.save(p);
		return "redirect:/listarclientes";
	}

	@GetMapping("/editarCliente/{id}")
	public ModelAndView formEditarcliente(@PathVariable("id") long id) {
		Cliente cliente = clienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

		ModelAndView modelAndView = new ModelAndView("editarcliente");
		modelAndView.addObject(cliente);
		return modelAndView;
	}

	@PostMapping("/editaCliente/{id}")
	public ModelAndView editarcliente(@PathVariable("id") long id, Cliente cliente) {
		clienteRepo.save(cliente);
		return new ModelAndView("redirect:/listarclientes");
	}

	@GetMapping("/removerCliente/{id}")
	public ModelAndView removercliente(@PathVariable("id") long id) {
		Cliente aRemover = clienteRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

		clienteRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarclientes");
	}
}
