package com.app_vendas_02.services_validation;

/**
 * ClienteInsertValidator
 */
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app_vendas_02.controller_exceptions.FieldMessage;
import com.app_vendas_02.domains.Cliente;
import com.app_vendas_02.dtos.ClienteNewDto;
import com.app_vendas_02.enums.TipoCliente;
import com.app_vendas_02.repositories.ClienteRepository;
import com.app_vendas_02.services_validation_utils.BR;

import org.springframework.beans.factory.annotation.Autowired;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDto> {

    @Autowired
    private ClienteRepository _clienteRepository;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDto objDto, ConstraintValidatorContext context) {

        Cliente aux = _clienteRepository.findByEmail(objDto.getEmail());

        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOA_FISICA.getCode()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {

            list.add(new FieldMessage("cpfOuCnpj", "CPF invalido."));
        }
        if (objDto.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCode()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {

            list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido."));
        }

        if (aux != null) {
            list.add(new FieldMessage("email", "Email ja cadastrado."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}