package com.FiapEShopping.repositories;


import com.FiapEShopping.model.ItensCarrinho;
import com.FiapEShopping.model.ItensCarrinhoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensCarrinhoRepository extends JpaRepository<ItensCarrinho, ItensCarrinhoId> {
}
