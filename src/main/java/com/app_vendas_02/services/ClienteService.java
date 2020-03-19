package com.app_vendas_02.services;

import java.util.List;
import java.util.Optional;

import com.app_vendas_02.domains.Cliente;
import com.app_vendas_02.dtos.ClienteDto;
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

    public Cliente update(Cliente obj) {
        Cliente newObj = findById(obj.getId());
        updateData(newObj, obj);
        return _repository.save(newObj);
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public Cliente fromDto(ClienteDto objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }
}