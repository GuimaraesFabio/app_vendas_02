package com.app_vendas_02.dtos;

import java.io.Serializable;

import com.app_vendas_02.domains.Cliente;

/**
 * ClienteDto
 */
public class ClienteDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private String email;

    public ClienteDto() {
    }

    public ClienteDto(Cliente obj) {

        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteDto id(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClienteDto nome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClienteDto email(String email) {
        this.email = email;
        return this;
    }

}