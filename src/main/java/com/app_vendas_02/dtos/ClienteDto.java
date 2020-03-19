package com.app_vendas_02.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.app_vendas_02.domains.Cliente;
import com.app_vendas_02.services_validation.ClienteUpdate;

import org.hibernate.validator.constraints.Length;

/**
 * ClienteDto
 */
@ClienteUpdate
public class ClienteDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo obrigatório")
    @Length(min = 5, max = 80, message = "Tamanho do campo nome deve ser de 5 a 80 caracteres.")
    private String nome;
    @NotEmpty(message = "Campo obrigatório")
    @Email(message = "Email invalido.")
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