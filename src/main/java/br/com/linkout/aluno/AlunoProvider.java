package br.com.linkout.aluno;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import br.com.linkout.DAO.AlunoDAO;
import br.com.linkout.modelo.Aluno;

import com.sun.jersey.api.json.JSONWithPadding;

@Path("/alunos")
public class AlunoProvider {
	
	private AlunoDAO dao = new AlunoDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONWithPadding getAll() {
		dao.beginTransaction();
		List<Aluno> listaDeAlunos = dao.findAll();
		dao.closeTransaction();
		return new JSONWithPadding(new GenericEntity<Collection<Aluno>>(listaDeAlunos){}, "lazim") ;
	}


	
	
	
}
