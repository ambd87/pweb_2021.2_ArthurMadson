package br.com.arthur.cadclientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.arthur.cadclientes.model.cliente;
import br.com.arthur.cadclientes.repositories.clienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
	@Autowired
	clienteRepository clienteRepo;

	ClienteController(clienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

	@GetMapping
	public String index() {
		return "index.html";
	}

	@GetMapping("/listarclientes")
	public ModelAndView listarclientes() {
		List<cliente> todasAsclientes = clienteRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarclientes");
		modelAndView.addObject("todasAsclientes", todasAsclientes);
		return modelAndView;
	}

	@GetMapping("/adicionarcliente")
	public ModelAndView formAdicionarcliente() {
		ModelAndView modelAndView = new ModelAndView("adicionarcliente");
		modelAndView.addObject(new cliente());
		return modelAndView;
	}

	@PostMapping("/adicionarcliente")
	public String adicionarcliente(cliente p) {
		this.clienteRepo.save(p);
		return "redirect:/listarclientes";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView formEditarcliente(@PathVariable("id") long id) {
		cliente cliente = clienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

		ModelAndView modelAndView = new ModelAndView("editarcliente");
		modelAndView.addObject(cliente);
		return modelAndView;
	}

	@PostMapping("/editar/{id}")
	public ModelAndView editarcliente(@PathVariable("id") long id, cliente cliente) {
		clienteRepo.save(cliente);
		return new ModelAndView("redirect:/listarclientes");
	}

	@GetMapping("/remover/{id}")
	public ModelAndView removercliente(@PathVariable("id") long id) {
		cliente aRemover = clienteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

		clienteRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarclientes");
	}
}
