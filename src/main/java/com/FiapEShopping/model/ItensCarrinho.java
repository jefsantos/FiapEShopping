package com.FiapEShopping.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ItensCarrinho {

	@EmbeddedId
	private ItensCarrinhoId id;

	@ManyToOne
	@MapsId("idItens")
	@JoinColumn(name = "id_itens")
	private Itens itens;

	@ManyToOne
	@MapsId("idCarrinho")
	@JoinColumn(name = "id_carrinho")
	private CarrinhoDeCompras carrinhoDeCompras;

	private int quantidade;

}
