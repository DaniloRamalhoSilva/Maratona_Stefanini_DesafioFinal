package br.com.stefanini.maratonadev.dto;

import java.time.LocalDateTime;


public class ClienteCarroDto {

		private int id;
		
    private String carro;
    
    private String cliente;
    
	private LocalDateTime data;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarro() {
		return carro;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

	
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
