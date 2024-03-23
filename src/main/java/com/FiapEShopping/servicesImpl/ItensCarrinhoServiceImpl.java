package com.FiapEShopping.servicesImpl;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapEShopping.model.Itens;
import com.FiapEShopping.model.ItensCarrinho;
import com.FiapEShopping.model.ItensCarrinhoId;
import com.FiapEShopping.repositories.ItensCarrinhoRepository;
import com.FiapEShopping.repositories.ItensRepository;
import com.FiapEShopping.services.ItensCarrinhoService;

@Service
public class ItensCarrinhoServiceImpl implements ItensCarrinhoService {

    private final ItensCarrinhoRepository itensCarrinhoRepository;
    
    
    


    @Autowired
    public ItensCarrinhoServiceImpl(ItensCarrinhoRepository itensCarrinhoRepository) {
        this.itensCarrinhoRepository = itensCarrinhoRepository;
    }
    
    @Autowired
    private  ItensRepository itensRepository;

    @Override
    public ItensCarrinho saveItensCarrinho(ItensCarrinho itensCarrinho) {

    	
    	
    	System.out.println(itensCarrinho.getItens().getId());
    	Itens itens = itensCarrinho.getItens();
    	
        if (validarQuantidadeItem(itens.getId(), itensCarrinho.getQuantidade())) {
            return itensCarrinhoRepository.save(itensCarrinho);
        } else {
            throw new IllegalArgumentException("A quantidade informada não é válida para o item selecionado.");
        }
    }

    @Override
    public ItensCarrinho getItensCarrinho(ItensCarrinhoId id) {
        return itensCarrinhoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ItensCarrinho> getAllItensCarrinho() {
        return itensCarrinhoRepository.findAll();
    }

    @Override
    public ItensCarrinho updateItensCarrinho(ItensCarrinhoId id, ItensCarrinho itensCarrinho) {
        ItensCarrinho existingItensCarrinho = itensCarrinhoRepository.findById(id).orElse(null);
        if (existingItensCarrinho != null) {
            itensCarrinho.setId(id);
            return itensCarrinhoRepository.save(itensCarrinho);
        }
        return null;
    }

    @Override
    public void deleteItensCarrinho(ItensCarrinhoId id) {
        itensCarrinhoRepository.deleteById(id);
    }
    
    @Override
    public ItensCarrinho updateQuantidadeItensCarrinho(ItensCarrinhoId id, int quantidade) {
        Optional<ItensCarrinho> existingItem = itensCarrinhoRepository.findById(id);
        if (existingItem.isPresent()) {
            if (validarQuantidadeItem(id.getIdItens(), quantidade)) {
                ItensCarrinho itensCarrinho = existingItem.get();
                itensCarrinho.setQuantidade(quantidade);
                return itensCarrinhoRepository.save(itensCarrinho);
            } else {
                throw new IllegalArgumentException("A quantidade informada não é válida para o item selecionado.");
            }
        }
        return null;
    }

    
    private boolean validarQuantidadeItem(UUID id , int quantidade) {
    	Optional<Itens> itensOptional = itensRepository.findById(id);
    	if(itensOptional.isPresent()) {
    		Itens itens = itensOptional.get();
    		if(itens.getQuantidadeEstoque()>= quantidade) {
    			return true;
    		}
    		
    	}
    	return false;
    	
    }
    
    
    
}
