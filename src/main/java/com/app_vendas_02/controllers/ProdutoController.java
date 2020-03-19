package com.app_vendas_02.controllers;

import java.util.List;

import com.app_vendas_02.controllers_utils.URL;
import com.app_vendas_02.domains.Categoria;
import com.app_vendas_02.domains.Produto;
import com.app_vendas_02.dtos.ProdutoDto;
import com.app_vendas_02.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProdutoController
 */

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService _service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto obj = _service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDto>> search(@RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value = "categorias", defaultValue = "") String categorias,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linePerPage", defaultValue = "24") Integer linePerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
        String nomeDeCode = URL.decodeParam(nome);
        List<Integer> ids = URL.listToInt(categorias);
        Page<Produto> list = _service.search(nomeDeCode, ids, page, linePerPage, direction, orderBy);
        Page<ProdutoDto> listDto = list.map(obj -> new ProdutoDto(obj));
        return ResponseEntity.ok().body(listDto);

    }

}