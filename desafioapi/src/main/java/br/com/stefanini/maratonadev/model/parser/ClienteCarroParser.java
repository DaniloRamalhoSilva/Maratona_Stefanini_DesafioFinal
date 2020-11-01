package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteCarroDto;
import br.com.stefanini.maratonadev.model.ClienteCarro;

public class ClienteCarroParser {
	
	public static ClienteCarroParser get() {
		return new ClienteCarroParser();
	}
	
	public ClienteCarro entidade(ClienteCarroDto dto) {
		ClienteCarro entidade = new ClienteCarro();
		
		entidade.setCarro(dto.getCarro());
		entidade.setId(dto.getId());
		entidade.setCliente(dto.getCliente());
		entidade.setData(dto.getData());	
		
		return entidade;
	}
	
	public ClienteCarroDto dto(ClienteCarro entidade) {
		
		ClienteCarroDto dto = new ClienteCarroDto();
		
		dto.setCarro(entidade.getCarro());
		dto.setId(entidade.getId());
		dto.setCliente(entidade.getCliente());
		dto.setData(entidade.getData());	
		
		return dto;
	}

}
