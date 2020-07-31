package br.com.natividade.estoque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.natividade.estoque.models.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long>{

}
