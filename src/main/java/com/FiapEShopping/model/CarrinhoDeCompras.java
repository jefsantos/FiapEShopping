package com.FiapEShopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CarrinhoDeCompras {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private UUID id;

 @OneToMany(cascade = CascadeType.ALL)
 private List<Itens> itens;

 public CarrinhoDeCompras() {
     this.itens = new ArrayList<>();
 }

 public UUID getId() {
     return id;
 }

 public void setId(UUID id) {
     this.id = id;
 }

 public List<Itens> getItens() {
     return itens;
 }

 public void setItens(List<Itens> itens) {
     this.itens = itens;
 }

 public void adicionarItens(Itens item) {
     this.itens.add(item);
 }
 
 public void removerItens(Itens item) {
     this.itens.remove(item);
 }


}