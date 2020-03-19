package com.app_vendas_02.controllers;

import java.util.List;

import com.app_vendas_02.domains.Cliente;
import com.app_vendas_02.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClienteController
 */

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService _service;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {

        List<Cliente> list = _service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente obj = _service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}