package com.app_vendas_02.controllers;

import java.net.URI;
import java.util.List;

import com.app_vendas_02.domains.Categoria;
import com.app_vendas_02.dtos.CategoriaDto;
import com.app_vendas_02.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * CategoriaController
 */

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService _service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {

        List<Categoria> list = _service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria obj = _service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<CategoriaDto>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linePerPage", defaultValue = "24") Integer linePerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

        Page<Categoria> list = _service.findPage(page, linePerPage, direction, orderBy);
        Page<CategoriaDto> listDto = list.map(obj -> new CategoriaDto(obj));
        return ResponseEntity.ok().body(listDto);

    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CategoriaDto objDto) {

        Categoria obj = _service.fromDto(objDto);
        obj = _service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody CategoriaDto objDto, @PathVariable Integer id) {

        Categoria obj = _service.fromDto(objDto);
        obj.setId(id);
        _service.update(obj);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        _service.delete(id);
        return ResponseEntity.noContent().build();
    }

}