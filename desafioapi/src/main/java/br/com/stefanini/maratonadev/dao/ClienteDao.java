package br.com.stefanini.maratonadev.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.stefanini.maratonadev.model.Cliente;



@RequestScoped
public class ClienteDao {
	
	@PersistenceContext
	EntityManager em;
	
	public void inserir(Cliente cliente) {

		cliente.persistAndFlush();
		//return cliente.getId();
	}
	

	public Boolean isClienteRepetido(String cpf) {
		String nomeSql = "CONSULTAR_NOME_REPETIDO";
		Boolean nomeRepetido = Boolean.FALSE;
		
		TypedQuery<Cliente> query = em.createNamedQuery(nomeSql, Cliente.class);
		query.setParameter("cpf", cpf);
		
		nomeRepetido = query.getResultList().size() > 0;
				
		return nomeRepetido;
	}

}
