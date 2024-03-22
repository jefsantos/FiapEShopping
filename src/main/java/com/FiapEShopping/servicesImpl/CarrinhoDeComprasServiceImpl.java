package com.FiapEShopping.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.model.Itens;
import com.FiapEShopping.model.DTO.ItemDTO;
import com.FiapEShopping.repositories.CarrinhoDeComprasRepository;
import com.FiapEShopping.services.CarrinhoDeComprasService;


@Service
public class CarrinhoDeComprasServiceImpl implements CarrinhoDeComprasService {

    private final CarrinhoDeComprasRepository carrinhoDeComprasRepository;

    @Autowired
    public CarrinhoDeComprasServiceImpl(CarrinhoDeComprasRepository carrinhoDeComprasRepository) {
        this.carrinhoDeComprasRepository = carrinhoDeComprasRepository;
    }

    @Override
    public List<CarrinhoDeCompras> listarCarrinhos() {
        return carrinhoDeComprasRepository.findAll();
    }

	@Override
	public CarrinhoDeCompras criarCarrinho(CarrinhoDeCompras carrinho) {
		return carrinhoDeComprasRepository.save(carrinho);
	}



}
