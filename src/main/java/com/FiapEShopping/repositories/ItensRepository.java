package com.FiapEShopping.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapEShopping.model.Itens;

public interface ItensRepository extends JpaRepository<Itens, UUID >{

}
