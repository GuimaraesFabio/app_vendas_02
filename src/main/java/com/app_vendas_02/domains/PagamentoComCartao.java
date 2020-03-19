package com.app_vendas_02.domains;

import javax.persistence.Entity;

import com.app_vendas_02.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PagamentoComCartao
 */
@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento descricao, Pedido pedido, Integer numeroDeParcelas) {
        super(id, descricao, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return this.numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComCartao numeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
        return this;
    }

}