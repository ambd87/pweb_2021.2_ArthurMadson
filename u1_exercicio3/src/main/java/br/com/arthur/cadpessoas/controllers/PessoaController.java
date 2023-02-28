br.com.arthur.controllers;


@Controller
@RequestMapping("/")

class PessoaController{
	
	//raiz do site localhost:8080/
	
	@GetMapping
	public String index(){
		
		return "index.html"
		
	}
	
}
