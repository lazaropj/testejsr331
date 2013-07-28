package br.com.linkout.aluno;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.linkout.modelo.Aluno;

@Path("/alunos")
public class AlunoProvider {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> getAll() {
		return null;
	}


	
	
	
}
