package com.app_vendas_02.repositories;

import com.app_vendas_02.domains.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProdutoRepository
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}