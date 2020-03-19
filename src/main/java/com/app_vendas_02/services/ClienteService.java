package com.app_vendas_02.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.app_vendas_02.domains.Cidade;
import com.app_vendas_02.domains.Cliente;
import com.app_vendas_02.domains.Endereco;
import com.app_vendas_02.dtos.ClienteDto;
import com.app_vendas_02.dtos.ClienteNewDto;
import com.app_vendas_02.enums.TipoCliente;
import com.app_vendas_02.repositories.CidadeRepository;
import com.app_vendas_02.repositories.ClienteRepository;
import com.app_vendas_02.repositories.EnderecoRepository;
import com.app_vendas_02.services_exceptions.DataIntegrityException;
import com.app_vendas_02.services_exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * ClienteService
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository _repository;

    @Autowired
    private CidadeRepository _cidadeRepository;

    @Autowired
    private EnderecoRepository _enderecoRepository;

    public List<Cliente> findAll() {
        return _repository.findAll();
    }

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = _repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Transactional
    public Cliente insert(Cliente obj) {
        if (obj.getId() == null) {
            _repository.save(obj);
            _enderecoRepository.saveAll(obj.getEnderecos());
        }
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = findById(obj.getId());
        updateData(newObj, obj);
        return _repository.save(newObj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            _repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Erro ao excluir o cliente, pois existem pedidos pedentes.");
        }
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public Cliente fromDto(ClienteDto objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }

    public Cliente fromDto(ClienteNewDto objDto) {

        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
                TipoCliente.toEnum(objDto.getTipo()));
        Cidade cid = _cidadeRepository.getOne(objDto.getCidadeId());
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
                objDto.getBairro(), objDto.getCep(), cli, cid);

        cli.getTelefones().add(objDto.getTelefone1());
        cli.getEnderecos().add(end);

        if (objDto.getTelefone2() != null) {
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if (objDto.getTelefone3() != null) {
            cli.getTelefones().add(objDto.getTelefone3());
        }

        return cli;
    }
}