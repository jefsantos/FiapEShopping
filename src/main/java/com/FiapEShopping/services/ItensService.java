package com.FiapEShopping.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.FiapEShopping.model.Itens;

@Service
public interface ItensService {
	
	Itens save (Itens itens);
	List<Itens> buscarTodosItens();
	Optional<Itens> buscarPorId(UUID id);
	void deletarAparelho (UUID id);
	

}
