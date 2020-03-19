package com.app_vendas_02.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app_vendas_02.domains.Pedido;
import com.app_vendas_02.domains.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ItemPedidoPk
 */

@Embeddable
public class ItemPedidoPk implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id.pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id.produto")
    private Produto produto;

    @JsonIgnore
    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ItemPedidoPk pedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    @JsonIgnore
    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ItemPedidoPk produto(Produto produto) {
        this.produto = produto;
        return this;
    }

}