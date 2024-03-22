package com.FiapEShopping.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FiapEShopping.model.ItensCarrinho;
import com.FiapEShopping.model.ItensCarrinhoId;
import com.FiapEShopping.services.ItensCarrinhoService;

@RestController
@RequestMapping("/itens-carrinho")
public class ItensCarrinhoController {

    private final ItensCarrinhoService itensCarrinhoService;

    @Autowired
    public ItensCarrinhoController(ItensCarrinhoService itensCarrinhoService) {
        this.itensCarrinhoService = itensCarrinhoService;
    }

    @PostMapping
    public ItensCarrinho saveItensCarrinho(@RequestBody ItensCarrinho itensCarrinho) {
        return itensCarrinhoService.saveItensCarrinho(itensCarrinho);
    }

    @GetMapping("/{id}")
    public ItensCarrinho getItensCarrinho(@PathVariable ItensCarrinhoId id) {
        return itensCarrinhoService.getItensCarrinho(id);
    }

    @GetMapping
    public List<ItensCarrinho> getAllItensCarrinho() {
        return itensCarrinhoService.getAllItensCarrinho();
    }

    @PutMapping("/{id}")
    public ItensCarrinho updateItensCarrinho(@PathVariable ItensCarrinhoId id, @RequestBody ItensCarrinho itensCarrinho) {
        return itensCarrinhoService.updateItensCarrinho(id, itensCarrinho);
    }

    @DeleteMapping("/{id}")
    public void deleteItensCarrinho(@PathVariable ItensCarrinhoId id) {
        itensCarrinhoService.deleteItensCarrinho(id);
    }
    
    @PatchMapping("/{id}/quantidade")
    public ItensCarrinho updateQuantidadeItensCarrinho(@PathVariable ItensCarrinhoId id, @RequestParam int quantidade) {
        return itensCarrinhoService.updateQuantidadeItensCarrinho(id, quantidade);
    }
}
