package com.ghisworks.ghislog.service;



import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghisworks.ghislog.model.Cliente;
import com.ghisworks.ghislog.model.Entrega;
import com.ghisworks.ghislog.model.StatusEntrega;
import com.ghisworks.ghislog.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private CadastroClienteService cadastroClienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega ) {
		Cliente cliente = cadastroClienteService.buscar(entrega.getCliente().getId());
				
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega); 
	}

}
