package com.app_vendas_02.services;

import java.util.List;
import java.util.Optional;

import com.app_vendas_02.domains.Cliente;
import com.app_vendas_02.repositories.ClienteRepository;
import com.app_vendas_02.services_exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClienteService
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository _repository;

    public List<Cliente> findAll() {
        return _repository.findAll();
    }

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = _repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}