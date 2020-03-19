package com.app_vendas_02.controllers;

import java.util.List;

import com.app_vendas_02.domains.Pedido;
import com.app_vendas_02.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PedidoController
 */

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService _service;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {

        List<Pedido> list = _service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        Pedido obj = _service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}