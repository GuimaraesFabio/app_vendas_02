package com.app_vendas_02.domains;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Pedido
 */

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "enderecoDeEntrega_id")
	private Endereco enderecoDeEntrega;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();

	public Pedido() {
	}

	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido id(Integer id) {
		this.id = id;
		return this;
	}

	public Date getInstante() {
		return this.instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pedido instante(Date instante) {
		this.instante = instante;
		return this;
	}

	public Pagamento getPagamento() {
		return this.pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Pedido pagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
		return this;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public Endereco getEnderecoDeEntrega() {
		return this.enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Pedido enderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
		return this;
	}

	public Set<ItemPedido> getItens() {
		return this.itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Pedido itens(Set<ItemPedido> itens) {
		this.itens = itens;
		return this;
	}

	public Double getValorTotal() {
		double sum = 0.0;
		for (ItemPedido x : itens) {
			sum += x.getSubTotal();
		}
		return sum;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Pedido)) {
			return false;
		}
		Pedido pedido = (Pedido) o;
		return Objects.equals(id, pedido.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {

		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		StringBuilder builder = new StringBuilder();
		builder.append("Pedido nº: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Situação do pagamento: ");
		builder.append(getPagamento().getDescricao());
		builder.append(", Cliente: ");
		builder.append(getCliente().getNome());
		builder.append("\nDetalhes:\n");
		for (ItemPedido ip : itens) {

			builder.append(ip.toString());

		}
		builder.append("\n");
		builder.append("ValorTotal: ");
		builder.append(nf.format(getValorTotal()));

		return builder.toString();
	}

}