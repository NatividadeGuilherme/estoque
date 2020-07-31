package br.com.natividade.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.natividade.estoque.dao.InventarioDAO;
import br.com.natividade.estoque.models.Inventario;

@Controller
@RequestMapping("/inventario")
public class InventarioController {

	@Autowired
	private InventarioDAO inventarioDAO;
	
	@GetMapping("/")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("/inventario/inventarios");
		
		List<Inventario> inventarios = inventarioDAO.findAll();
		
		modelAndView.addObject("inventarios", inventarios);
		
		return modelAndView;
		
	}
}
