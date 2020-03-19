package com.app_vendas_02.dtos;

import java.io.Serializable;

import com.app_vendas_02.domains.Categoria;

/**
 * CategoriaDto
 */
public class CategoriaDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;

    public CategoriaDto() {

    }

    public CategoriaDto(Categoria obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoriaDto id(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaDto nome(String nome) {
        this.nome = nome;
        return this;
    }

}