package br.com.stefanini.maratonadev.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;


@RequestScoped
public class ClienteService {
	
	@Inject
	ClienteDao dao;
	
	private void validar(Cliente cliente) {
		
		if(dao.isClienteRepetido(cliente.getCpf())) {
		throw new NotFoundException();

		}
	}

	@Transactional(rollbackOn = Exception.class)
	public void inserir(ClienteDto clienteDto) {
		
		Cliente cliente = ClienteParser.get().entidade(clienteDto);
		validar(cliente);
		
		dao.inserir(cliente);
				
	}
	
	

}
