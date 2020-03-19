package com.app_vendas_02.repositories;

import com.app_vendas_02.domains.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EnderecoRepository
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}