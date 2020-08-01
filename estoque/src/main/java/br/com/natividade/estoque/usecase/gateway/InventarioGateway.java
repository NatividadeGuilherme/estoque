package br.com.natividade.estoque.usecase.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.natividade.estoque.dataprovider.model.Inventario;

@Component
public interface InventarioGateway {

	Optional<List<Inventario>> listar();
}
