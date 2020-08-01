package br.com.natividade.estoque.usecase.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.natividade.estoque.usecase.domain.ProdutoDomain;

@Component
public interface ProdutoGateway {
	void gravar(ProdutoDomain produto);
	Optional<List<ProdutoDomain>> listar();
	void deletar(long id);
	void editar(ProdutoDomain produto);
	Optional<ProdutoDomain> obterPorId(long id);
}
