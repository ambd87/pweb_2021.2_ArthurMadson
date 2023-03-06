package br.con.arthur.cadpessoas.controllers:
import java.util.List;
Import
import
org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; org.springframework.web.bind.annotation.GetMapping: org.springframework.web.bind.annotation.PostMapping; org.springframework.web.bind.amotation.RequestMapping:
import Import
import org.springframework.web.servlet.ModelAndView:
import br.com.xico.cadpessoas.model.Fesspa;
import.br.com.xico.cadoessoas.repositories.PessoaRepository;
@Controller
@RequestMapping("/")

public PessoaController(Pessoa Repository pessoarepo){ this.pessoaRepo = pessoaRepo;

GetMapping
public String index()
}
return "index.html";
I
@GetMapping("/listarPessoas")
public Model Andview listarPessoas() {
List<Pessoa> todasAsPessoas pessoa Repo.findALL();
ModelAndView modelAndView = new ModelAndView("listarPessoas"); nodelAndView.addObject("todasAsPessoas, todasAsPessoas);
return nodelAndView:
GetMapping("/adicionarPessoa")
public ModelAndView formularioAdicionarPessoas() {
Model Andview model Andview new ModelAndView("adicionarPessoa'); mode Landview.addObject(new Pessoa());
return nodelAndView;


RGetMapping("/listarPessoas")
public ModelAndview listarPessoas() {
List<Pessoa> todasAsPessoas pessoaRepo.findALL();
ModelAndView model Andview new ModelAndView("ListarPessoas"); node LAndView.addObject("todasAsPessoas, todasAsPessoas); return nodelAndView:
GetMapping("/adicionarPessoa")
public ModelAndview formularioAdicionarPessoas() |
}
Model Andview model Andview = new ModelAndView("adicionarPessoa"); nodeLandView.addObject(new Pessoa());
return nodelAndView;
PostMapping/adicionarPessoa
public String adicionar Pessoa (Pessoa p){
this.pessoaRepo.save(p);
return "redirect:/listarPessoas";
@GetMapping("/remover/{id}")
public ModelAndView removerPessoa (@PathVariable("id") long id) {
Pessoa aRemover = pessoaRepo.findById(id)
.orElseThrow(()->new IllegalArgumentException("ID inválido=" + id));
pessoaRepo.delete(aRemover);
return new ModelAndView("redirect:/listarPessoas");
}