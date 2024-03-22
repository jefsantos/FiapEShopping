package com.FiapEShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FiapEShopping.model.CarrinhoDeCompras;
import com.FiapEShopping.services.CarrinhoDeComprasService;

@RestController
@RequestMapping("/api")
public class CarrinhoDeComprasController {

    private final CarrinhoDeComprasService carrinhoDeComprasService;

    @Autowired
    public CarrinhoDeComprasController(CarrinhoDeComprasService carrinhoDeComprasService) {
        this.carrinhoDeComprasService = carrinhoDeComprasService;
    }
    
    @PostMapping("/criarCarrinho")
    public ResponseEntity<CarrinhoDeCompras> criarCarrinho(@RequestBody CarrinhoDeCompras carrinho ) {
        CarrinhoDeCompras novoCarrinho = carrinhoDeComprasService.criarCarrinho(carrinho);
        return ResponseEntity.ok(novoCarrinho);
    }

    @GetMapping("/listarCarrinho")
    public List<CarrinhoDeCompras> listarCarrinhos() {
        return carrinhoDeComprasService.listarCarrinhos();
    }

}
