package com.app_vendas_02.repositories;

import com.app_vendas_02.domains.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PedidoRepository
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}