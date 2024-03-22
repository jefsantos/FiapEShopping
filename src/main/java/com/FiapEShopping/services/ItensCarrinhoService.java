package com.FiapEShopping.services;



import com.FiapEShopping.model.ItensCarrinho;
import com.FiapEShopping.model.ItensCarrinhoId;
import java.util.List;

public interface ItensCarrinhoService {
    ItensCarrinho saveItensCarrinho(ItensCarrinho itensCarrinho);
    ItensCarrinho getItensCarrinho(ItensCarrinhoId id);
    List<ItensCarrinho> getAllItensCarrinho();
    ItensCarrinho updateItensCarrinho(ItensCarrinhoId id, ItensCarrinho itensCarrinho);
    void deleteItensCarrinho(ItensCarrinhoId id);
    ItensCarrinho updateQuantidadeItensCarrinho(ItensCarrinhoId id, int quantidade);
}
