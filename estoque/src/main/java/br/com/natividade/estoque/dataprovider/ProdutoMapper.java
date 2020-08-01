package br.com.natividade.estoque.dataprovider;

import java.util.ArrayList;
import java.util.List;

import br.com.natividade.estoque.dataprovider.model.Produto;
import br.com.natividade.estoque.usecase.domain.ProdutoDomain;

public class ProdutoMapper {
	private ProdutoMapper() {}
	
	public static Produto toModel(ProdutoDomain domain) {
		
		Produto produto = new Produto();
		produto.setDataFabricacao(domain.getDataFabricacao());
		produto.setNome(domain.getNome());
		produto.setQuantidade(domain.getQuantidade());
		
		return produto;
	}
	
	public static List<ProdutoDomain> from(List<Produto> produtos){
		List<ProdutoDomain> produtosDomain = new ArrayList<>();
		
		produtos.forEach((produto) -> {
			produtosDomain.add(toDomain(produto));
		});
		
		return produtosDomain;
	}
	
	private static ProdutoDomain toDomain(Produto produto) {
		ProdutoDomain produtoDomain = new ProdutoDomain();
		produtoDomain.setDataFabricacao(produto.getDataFabricacao());
		produtoDomain.setNome(produto.getNome());
		produtoDomain.setQuantidade(produto.getQuantidade());
		produtoDomain.setId(produto.getId());
		
		return produtoDomain;
		
	}
}
