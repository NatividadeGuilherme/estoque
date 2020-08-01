package br.com.natividade.estoque.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.natividade.estoque.usecase.domain.ProdutoDomain;
import br.com.natividade.estoque.usecase.gateway.ProdutoGateway;


public class ProdutoUseCase {
	
	@Autowired
	private ProdutoGateway produtoGateway;
	
	public List<ProdutoDomain> listar(){
		Optional<List<ProdutoDomain>> produtos = produtoGateway.listar();
		
		if(!produtos.isPresent()) {
			throw new NullPointerException("Nenhum produto encontrado!");
		}
		
		return produtos.get();
	}
	
	public void gravar(ProdutoDomain produto) {
		
		produtoGateway.gravar(produto);
	}
}
