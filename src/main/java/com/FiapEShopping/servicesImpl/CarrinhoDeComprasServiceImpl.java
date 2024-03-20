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
    public void adicionarItens(UUID carrinhoId, ItemDTO itemDTO) {
        Optional<CarrinhoDeCompras> optionalCarrinho = carrinhoDeComprasRepository.findById(carrinhoId);
        if (optionalCarrinho.isPresent()) {
            CarrinhoDeCompras carrinho = optionalCarrinho.get();
            
            Itens item = new Itens();
            item.setNome(itemDTO.getNome());
            
            carrinho.adicionarItens(item);
            carrinhoDeComprasRepository.save(carrinho);
        } else {
            // Tratar caso em que o carrinho não é encontrado
        }
    }


    @Override
    public void removerItens(UUID carrinhoId, UUID itensId) {
        Optional<CarrinhoDeCompras> optionalCarrinho = carrinhoDeComprasRepository.findById(carrinhoId);
        if (optionalCarrinho.isPresent()) {
            CarrinhoDeCompras carrinho = optionalCarrinho.get();
            List<Itens> itens = carrinho.getItens();
            for (Itens Itens : itens) {
                if (Itens.getId().equals(itensId)) {
                    itens.remove(Itens);
                    carrinhoDeComprasRepository.save(carrinho);
                    return;
                }
            }
        }
        // Tratar caso em que o carrinho não é encontrado ou o Itens não está presente no carrinho
    }

	@Override
	public CarrinhoDeCompras criarCarrinho(CarrinhoDeCompras carrinho) {
		return carrinhoDeComprasRepository.save(carrinho);
	}

}
