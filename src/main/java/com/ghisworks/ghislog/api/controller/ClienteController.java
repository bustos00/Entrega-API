package com.ghisworks.ghislog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghisworks.ghislog.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() { 
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Nikola");
		cliente1.setTelefone("98 xxxxx-xxxx");
		cliente1.setEmail("nikolamalov@ghislog.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Mia"); 
		cliente2.setTelefone("99 99999-1111");
		cliente2.setEmail("miariche@ghislog.com");
		
		
		
		return Arrays.asList(cliente1, cliente2);
	}
}
