package com.app_vendas_02.services;

import java.util.List;
import java.util.Optional;

import com.app_vendas_02.domains.Pedido;
import com.app_vendas_02.repositories.PedidoRepository;
import com.app_vendas_02.services_exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PedidoService
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository _repository;

    public List<Pedido> findAll() {
        return _repository.findAll();
    }

    public Pedido findById(Integer id) {
        Optional<Pedido> obj = _repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}