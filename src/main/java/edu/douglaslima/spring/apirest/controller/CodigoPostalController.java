package edu.douglaslima.spring.apirest.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.douglaslima.spring.apirest.handler.BusinessException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cep")
public class CodigoPostalController {

	@GetMapping("/search/{ibge}")
	public String getCidade(@PathVariable String ibge) {
		if (ibge.equals("123456789")) {
			return "São Paulo";
		} else {
			throw new BusinessException(String.format("Não localizamos nenhuma cidade com o código: %s.", ibge));
		}
	}

}
