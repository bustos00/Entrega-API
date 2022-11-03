package com.ghisworks.ghislog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghisworks.ghislog.exception.ExceptionNegocio;
import com.ghisworks.ghislog.model.Cliente;
import com.ghisworks.ghislog.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CadastroClienteService {
	
	private ClienteRepository clienteRepository;
	
	 public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ExceptionNegocio("Cliente não encontrado"));
	 }
	
	@Transactional 
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			 throw new ExceptionNegocio("Já existe um cliente cadastrado com este e-mail");
		}
		
		return clienteRepository.save(cliente);
		
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}
