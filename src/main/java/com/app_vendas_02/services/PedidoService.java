package com.app_vendas_02.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.app_vendas_02.domains.ItemPedido;
import com.app_vendas_02.domains.PagamentoComBoleto;
import com.app_vendas_02.domains.Pedido;
import com.app_vendas_02.enums.EstadoPagamento;
import com.app_vendas_02.repositories.ItemPedidoRepository;
import com.app_vendas_02.repositories.PagamentoRepository;
import com.app_vendas_02.repositories.PedidoRepository;
import com.app_vendas_02.services_exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PedidoService
 */
@Service
public class PedidoService {

	@Autowired
	private PedidoRepository _repository;

	@Autowired
	private BoletoService _boletoService;

	@Autowired
	private PagamentoRepository _pagamentoRepository;

	@Autowired
	private ProdutoService _produtoService;

	@Autowired
	private ItemPedidoRepository _itemPedidoRepository;
	
	@Autowired
	private ClienteService _clienteService;

	public List<Pedido> findAll() {
		return _repository.findAll();
	}

	public Pedido findById(Integer id) {
		Optional<Pedido> obj = _repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	@Transactional
	public Pedido insert(Pedido obj) {

		obj.setId(null);
		obj.setInstante(new Date());
		obj.getCliente().setNome(_clienteService.findById(obj.getCliente().getId()).getNome());
		obj.getPagamento().setDescricao(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);

		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			_boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}

		obj = _repository.save(obj);
		_pagamentoRepository.save(obj.getPagamento());

		for (ItemPedido ip : obj.getItens()) {

			ip.setDesconto(0.0);
			ip.setProduto(_produtoService.findById(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}

		_itemPedidoRepository.saveAll(obj.getItens());
		System.out.println(obj.toString());
		return obj;

	}
}