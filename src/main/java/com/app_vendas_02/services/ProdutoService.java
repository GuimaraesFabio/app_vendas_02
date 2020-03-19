package com.app_vendas_02.services;

import java.util.List;
import java.util.Optional;

import com.app_vendas_02.domains.Categoria;
import com.app_vendas_02.domains.Produto;
import com.app_vendas_02.repositories.CategoriaRepository;
import com.app_vendas_02.repositories.ProdutoRepository;
import com.app_vendas_02.services_exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ProdutoService
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository _repository;

    @Autowired
    private CategoriaRepository _categoriaRepository;

    public Produto findById(Integer id) {
        Optional<Produto> obj = _repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @GetMapping
    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linePerPage, String direction,
            String orderBy) {

        PageRequest pr = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = _categoriaRepository.findAllById(ids);
        return _repository.search(nome, categorias, pr);
    }
}