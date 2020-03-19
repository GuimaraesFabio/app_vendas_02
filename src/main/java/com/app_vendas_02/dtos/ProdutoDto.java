package com.app_vendas_02.dtos;

import java.io.Serializable;

import com.app_vendas_02.domains.Produto;

/**
 * ProdutoDto
 */
public class ProdutoDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDto() {
    }

    public ProdutoDto(Produto obj) {

        id = obj.getId();
        nome = obj.getNome();
        preco = obj.getPreco();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProdutoDto id(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutoDto nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ProdutoDto preco(Double preco) {
        this.preco = preco;
        return this;
    }

}