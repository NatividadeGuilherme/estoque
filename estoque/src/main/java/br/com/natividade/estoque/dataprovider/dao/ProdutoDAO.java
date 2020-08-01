package br.com.natividade.estoque.dataprovider.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.natividade.estoque.dataprovider.model.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long>{

}
