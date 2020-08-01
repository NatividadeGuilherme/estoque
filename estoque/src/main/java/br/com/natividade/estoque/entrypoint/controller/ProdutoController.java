package br.com.natividade.estoque.entrypoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.natividade.estoque.usecase.ProdutoUseCase;
import br.com.natividade.estoque.usecase.domain.ProdutoDomain;

@Controller
@RequestMapping("produto")
public class ProdutoController {

//	@Autowired
//	private ProdutoDAO produtoDAO;
	
	@Autowired 
	private ProdutoUseCase produtoUseCase;
//	
//	@GetMapping("/adicionar")
//	public ModelAndView formGravar() {
//		ModelAndView modelAndView = new ModelAndView("/produto/formProduto");
//		
//		modelAndView.addObject("produto", new ProdutoDomain());
//		return modelAndView;
//	}
	
//	@PostMapping("/adicionar")
//	public String formGravar(ProdutoDomain produto) {
//		System.out.println("Estou dentro do post");
//		
////		produtoDAO.save(produto);
//		
//		return "redirect:/produto/produtos";
//	}
	
	@GetMapping("/produtos")
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView("/produto/produtos");
		
		List<ProdutoDomain> produtos = produtoUseCase.listar();
		
		modelView.addObject("produtos", produtos);
		
		return modelView;
	}
	
//	@GetMapping("/editar/{id}")
//	public ModelAndView editar(@PathVariable("id") long id) {
//		ModelAndView modelAndView = new ModelAndView("/produto/editar");
//		
////		Optional<Produto> produto = produtoDAO.findById(id);
//		
////		modelAndView.addObject("produto", produto.get());
//		
//		return modelAndView;
//	}
	
//	@PostMapping("/editar")
//	public String editar(Produto produto) {
//				
////		produtoDAO.save(produto);
//		
//		return "redirect:/produto/produtos";
//	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") long id) {
//		produtoDAO.deleteById(id);
		
		return new ModelAndView("redirect:/produto/produtos");
	}

}
