package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;

public class ClienteParser {
	
	public static ClienteParser get() {
		return new ClienteParser();
	}
	public Cliente entidade(ClienteDto dto) {
		Cliente entidade = new Cliente();
		
		entidade.setCpf(dto.getCpf());
		entidade.setCep(dto.getCep());
		entidade.setComCarro(dto.getComCarro());
		entidade.setContato(dto.getContato());
		entidade.setEmail(dto.getEmail());
		entidade.setNome(dto.getNome());
		
		return entidade;
	}
	
	public ClienteDto dto(Cliente entidade) {
		
		ClienteDto dto = new ClienteDto();
		
		dto.setCpf(entidade.getCpf());
		dto.setCep(entidade.getCep());
		dto.setComCarro(entidade.getComCarro());
		dto.setContato(entidade.getContato());
		dto.setEmail(entidade.getEmail());
		dto.setNome(entidade.getNome());
		
		return dto;
	}

}
