package br.com.stefanini.maratonadev.rest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.ClienteCarroDto;
import br.com.stefanini.maratonadev.service.ClienteCarroService;


@Path("cliente_carro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteCarroRest {
	
	@Inject
	ClienteCarroService service;
	
	@Inject
	Validator validador;
	
	
	@POST
	@Path("")
	@Operation(summary = "Alugar um Carro",
	description = "Cadastra um Cliente para alugar um carro")
	@APIResponse(responseCode = "201",
	description = "Alugar um Carro",
	content = {
			@Content(mediaType = "application/json",
			schema = @Schema(implementation = ClienteCarroDto.class))
			}
	)
	public Response criar(ClienteCarroDto ClienteCarro) {
		
		Set<ConstraintViolation<ClienteCarroDto>> erros
		= validador.validate(ClienteCarro);
		
		if(erros.isEmpty()) {
			service.alugar(ClienteCarro);
		}else {
			List<String> listaErros = erros.stream()
			.map(ConstraintViolation::getMessage)
			.collect(Collectors.toList());
			throw new NotFoundException(listaErros.get(0));
		}
		
		return Response
				.status(Status.CREATED)
				.build();
	}
	
	

}
