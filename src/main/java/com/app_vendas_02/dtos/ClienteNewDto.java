package com.app_vendas_02.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.app_vendas_02.services_validation.ClienteInsert;

import org.hibernate.validator.constraints.Length;

/**
 * ClienteNewDto
 */

@ClienteInsert
public class ClienteNewDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo obrigatório")
    @Length(min = 5, max = 120, message = "Tamanho do campo nome deve ser de 5 a 120 caracteres.")
    private String nome;
    @NotEmpty(message = "Campo obrigatório")
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    @NotEmpty(message = "Campo obrigatório")
    private String logradouro;
    private String numero;
    @NotEmpty(message = "Campo obrigatório")
    private String complemento;
    private String bairro;
    @NotEmpty(message = "Campo obrigatório")
    private String cep;

    @NotEmpty(message = "Campo obrigatório")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;

    public ClienteNewDto() {
    }

    public ClienteNewDto(String nome, String email, String cpfOuCnpj, Integer tipo, String logradouro, String numero,
            String complemento, String bairro, String cep, String telefone1, String telefone2, String telefone3,
            Integer cidadeId) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.cidadeId = cidadeId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClienteNewDto nome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClienteNewDto email(String email) {
        this.email = email;
        return this;
    }

    public String getCpfOuCnpj() {
        return this.cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public ClienteNewDto cpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
        return this;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public ClienteNewDto tipo(Integer tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public ClienteNewDto logradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ClienteNewDto numero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public ClienteNewDto complemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public ClienteNewDto bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ClienteNewDto cep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getTelefone1() {
        return this.telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public ClienteNewDto telefone1(String telefone1) {
        this.telefone1 = telefone1;
        return this;
    }

    public String getTelefone2() {
        return this.telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public ClienteNewDto telefone2(String telefone2) {
        this.telefone2 = telefone2;
        return this;
    }

    public String getTelefone3() {
        return this.telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public ClienteNewDto telefone3(String telefone3) {
        this.telefone3 = telefone3;
        return this;
    }

    public Integer getCidadeId() {
        return this.cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public ClienteNewDto cidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
        return this;
    }

}