package com.app_vendas_02.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app_vendas_02.pks.ItemPedidoPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ItemPedido
 */

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemPedidoPk id = new ItemPedidoPk();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {

        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public ItemPedidoPk getId() {
        return this.id;
    }

    public void setId(ItemPedidoPk id) {
        this.id = id;
    }

    public ItemPedido id(ItemPedidoPk id) {
        this.id = id;
        return this;
    }

    public Double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public ItemPedido desconto(Double desconto) {
        this.desconto = desconto;
        return this;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ItemPedido quantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ItemPedido preco(Double preco) {
        this.preco = preco;
        return this;
    }

    public Double getSubTotal() {
        return (getPreco() - getDesconto()) * getQuantidade();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemPedido)) {
            return false;
        }
        ItemPedido itemPedido = (ItemPedido) o;
        return Objects.equals(id, itemPedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}