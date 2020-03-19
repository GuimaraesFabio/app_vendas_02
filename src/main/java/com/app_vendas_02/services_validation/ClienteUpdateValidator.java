package com.app_vendas_02.services_validation;

/**
 * ClienteUpdateValidator
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.app_vendas_02.controller_exceptions.FieldMessage;
import com.app_vendas_02.domains.Cliente;
import com.app_vendas_02.dtos.ClienteDto;
import com.app_vendas_02.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDto> {

    @Autowired
    private HttpServletRequest _request;

    @Autowired
    private ClienteRepository _clienteRepository;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDto objDto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) _request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer auxId = Integer.parseInt(map.get("id"));

        Cliente aux = _clienteRepository.findByEmail(objDto.getEmail());

        List<FieldMessage> list = new ArrayList<>();

        if (aux != null && !aux.getId().equals(auxId)) {
            list.add(new FieldMessage("email", "Email já cadastrado."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
