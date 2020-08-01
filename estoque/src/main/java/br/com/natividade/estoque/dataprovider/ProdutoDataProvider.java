package br.com.natividade.estoque.dataprovider;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.natividade.estoque.dataprovider.dao.ProdutoDAO;
import br.com.natividade.estoque.dataprovider.model.Produto;
import br.com.natividade.estoque.usecase.domain.ProdutoDomain;
import br.com.natividade.estoque.usecase.gateway.ProdutoGateway;

public class ProdutoDataProvider implements ProdutoGateway {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Override
	public void gravar(ProdutoDomain produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<List<ProdutoDomain>> listar() {
		List<Produto> produtos = produtoDAO.findAll();
		
		if(produtos.isEmpty()) {
			return Optional.empty();
		}
		
		return Optional.of(ProdutoMapper.from(produtos));
	}

	@Override
	public void deletar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(ProdutoDomain produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<ProdutoDomain> obterPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
