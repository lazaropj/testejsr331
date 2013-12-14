package br.com.linkout.aluno;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.server.JSONP;

import br.com.linkout.DAO.AlunoDAO;
import br.com.linkout.modelo.Aluno;

@Path("/alunos")
public class AlunoProvider {
	
	private AlunoDAO dao = new AlunoDAO();

	@GET
	@JSONP(callback = "eval", queryParam = "jsonpCallback")
	@Produces({"application/json", "application/javascript"})
	public List<Aluno> getAll() {
		dao.beginTransaction();
		List<Aluno> listaDeAlunos = dao.findAll();
		dao.closeTransaction();
		return listaDeAlunos;
	}


	
	
	
}
