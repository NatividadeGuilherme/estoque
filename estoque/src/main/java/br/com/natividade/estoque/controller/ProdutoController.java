package br.com.natividade.estoque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.natividade.estoque.dao.ProdutoDAO;
import br.com.natividade.estoque.models.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GetMapping("/adicionar")
	public ModelAndView formGravar() {
		ModelAndView modelAndView = new ModelAndView("/produto/formProduto");
		
		modelAndView.addObject("produto", new Produto());
		return modelAndView;
	}
	
	@PostMapping("/adicionar")
	public String formGravar(Produto produto) {
		System.out.println("Estou dentro do post");
		
		produtoDAO.save(produto);
		
		return "redirect:/produto/produtos";
	}
	
	@GetMapping("/produtos")
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView("/produto/produtos");
		
		List<Produto> produtos = produtoDAO.findAll();
		
		modelView.addObject("produtos", produtos);
		
		return modelView;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView("/produto/editar");
		
		Optional<Produto> produto = produtoDAO.findById(id);
		
		modelAndView.addObject("produto", produto.get());
		
		return modelAndView;
	}
	
	@PostMapping("/editar")
	public String editar(Produto produto) {
				
		produtoDAO.save(produto);
		
		return "redirect:/produto/produtos";
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") long id) {
		produtoDAO.deleteById(id);
		
		return new ModelAndView("redirect:/produto/produtos");
	}

}
