package br.com.stefanini.maratonadev.dto;

import org.hibernate.validator.constraints.Length;

public class ClienteDto {
	
	
	private String cpf;
	
	@Length(min = 3, max = 100, message = "Não é permido nomes menores que 3 caracteres ou maiores que 250")	
    private String nome;
    
    private String cep;
    
    private String email;
    
    private String contato;
    
    private String comCarro;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getComCarro() {
		return comCarro;
	}

	public void setComCarro(String comCarro) {
		this.comCarro = comCarro;
	}
    
    

}
