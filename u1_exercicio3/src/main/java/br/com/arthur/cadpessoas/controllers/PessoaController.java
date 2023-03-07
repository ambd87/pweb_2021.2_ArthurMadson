package br.com.arthur.cadpessoas.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.arthur.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController{
	
	
	@AutoWired
	PessoaRepository pessoaRepo;
	
	public PessoaController(PessoaRepository pessoaRepo){
		
		this.pessoaRepo = pessoaRepo;
		
		
	}
	
	@GetMapping
		public String index(){
			return "index.html";
			
		}
		
	@GetMapping("/listarPessoas")
	public ModelAndView listarPessoas(){
		
		List<Pessoa>   todasAsPessoas = pessoaRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("listarPessoas");
 		modelAndView.addObject("todasAsPessoas", todasAsPessoas);
		
		return  modelAndView;
		
	}
	 
	 @GetMapping("/adicionarPessoas")
	 public ModelAndView formularioAdicionarPessoas(){
		
		List<Pessoa>   todasAsPessoas = pessoaRepo.findAll();
		ModelAndView modelAndView = new ModelAndView("adicionarPessoas");
 		modelAndView.addObject(new Pessoa());
		
		return  modelAndView;
		
	}
	
		@PostMapping("/adicionarPessoa")
			public String adicionarPessoa(Pessoa p){
				this.pessoaRepo.save.(p);
					return "redirect:/listarPessoas";
			
			}
}