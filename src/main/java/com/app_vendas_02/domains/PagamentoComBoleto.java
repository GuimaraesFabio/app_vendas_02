package com.app_vendas_02.domains;

import java.util.Date;

import javax.persistence.Entity;

import com.app_vendas_02.enums.EstadoPagamento;

/**
 * PagamentoComBoleto
 */

 @Entity
public class PagamentoComBoleto extends Pagamento {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento descricao, Pedido pedido, Date dataVencimento,
            Date dataPagamento) {
        super(id, descricao, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public PagamentoComBoleto dataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
        return this;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public PagamentoComBoleto dataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
        return this;
    }

}