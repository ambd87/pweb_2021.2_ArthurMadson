package br.com.arthur.cadpessoas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
 public class PessoaController {
	
	@AutoWired
	PessoaRepository pessoaRepo;
	
	public PessoaController(PessoaRepository PessoaRepo){
		
		 this.pessoaRepo = pessoaRepo;
		
	}
	
	// raiz do site localhost:8080/
	@GetMapping
	public String index() {
		return "index.html";

	}
	
	 @GetMapping("/listarPessoas")
	 public ModelAndView listarPessoas(){
		 
		 List<Pessoa> todasAsPessoas = pessoaRepo.findAll();
		 ModelAndView modelAndView = new ModelAndView("listarPessoas");
		 ModelAndView.addObject("todasAsPessoas", todasAsPessoas);
		 return modelAndView;
		 
	 }
	 
	  @GetMapping("/adicionarPessoa")
	 public ModelAndView formularioAdicionarPessoas(){
		 
		 List<Pessoa> todasAsPessoas = pessoaRepo.findAll();
		 ModelAndView modelAndView = new ModelAndView("adicionarPessoa");
		 ModelAndView.addObject(new Pessoa());
		 
		 return modelAndView;
		 
	 }
	 
	
}
