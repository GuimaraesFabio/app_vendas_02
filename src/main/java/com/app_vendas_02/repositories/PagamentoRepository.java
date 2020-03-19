package com.app_vendas_02.repositories;

import com.app_vendas_02.domains.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PagamentoRepository
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}