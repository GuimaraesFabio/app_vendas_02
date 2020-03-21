package com.app_vendas_02.services;

import org.springframework.mail.SimpleMailMessage;

import com.app_vendas_02.domains.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void senderEmail(SimpleMailMessage msg);
}
