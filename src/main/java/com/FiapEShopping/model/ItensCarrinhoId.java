package com.FiapEShopping.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.Getter;


@Embeddable
@Getter
public class ItensCarrinhoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID idItens;
    private UUID idCarrinho;
}
