package br.com.stefanini.maratonadev.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.ClienteCarroDao;
import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteCarroDto;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.ClienteCarro;
import br.com.stefanini.maratonadev.model.parser.ClienteCarroParser;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

@RequestScoped
public class ClienteCarroService {
	
	@Inject
	ClienteCarroDao dao;
	
	private void validar(ClienteCarro clienteCarro) {
		
		//validar se carro ja esta alugado

		
	}

	@Transactional(rollbackOn = Exception.class)
	public void alugar(ClienteCarroDto clienteCarroDto) {
		
		ClienteCarro clienteCarro = ClienteCarroParser.get().entidade(clienteCarroDto);
								
		validar(clienteCarro);
		
		dao.alugar(clienteCarro);
				
	}
	
		
}
