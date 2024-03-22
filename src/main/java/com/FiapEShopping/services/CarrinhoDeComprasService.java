package com.FiapEShopping.services;

import java.util.List;
import java.util.UUID;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Itens;
import com.FiapEShopping.model.DTO.ItemDTO;

public interface CarrinhoDeComprasService {
    List<CarrinhoDeCompras> listarCarrinhos();
    CarrinhoDeCompras criarCarrinho (CarrinhoDeCompras carrinho);
    
    
    
}