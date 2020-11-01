package br.com.stefanini.maratonadev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "Cliente")
@NamedNativeQueries({
	@NamedNativeQuery(name="CONSULTAR_NOME_REPETIDO", query = ""
			+ "SELECT * FROM Cliente where cpf = :cpf", resultClass = Cliente.class),
	
})
public class Cliente extends PanacheEntityBase  {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;
		
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "cep", nullable = false)
    private String cep;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "contato", nullable = false)
    private String contato;
    
    @Column(name = "comCarro")
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
