package com.app_vendas_02.services;

import java.util.Calendar;
import java.util.Date;

import com.app_vendas_02.domains.PagamentoComBoleto;

import org.springframework.stereotype.Service;

/**
 * BoletoService
 */
@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instantePagamento) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(instantePagamento);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDataPagamento(cal.getTime());
    }
}