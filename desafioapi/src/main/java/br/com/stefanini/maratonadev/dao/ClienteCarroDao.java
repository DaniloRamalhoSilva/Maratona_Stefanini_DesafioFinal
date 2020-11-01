package br.com.stefanini.maratonadev.dao;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.ClienteCarro;


@RequestScoped
public class ClienteCarroDao {
	
	public void alugar(ClienteCarro clienteCarro) {

		clienteCarro.persistAndFlush();
		//return cliente.getId();
	}


}
