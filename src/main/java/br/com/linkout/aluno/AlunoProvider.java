package br.com.linkout.aluno;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.JSONP;

import br.com.linkout.DAO.AlunoDAO;
import br.com.linkout.modelo.Aluno;


@Provider
@Path("/alunos")
public class AlunoProvider {
	
	private AlunoDAO dao = new AlunoDAO();

	@GET
	@JSONP(callback = "eval", queryParam = "jsonpCallback")
	@Produces({"application/javascript","application/json"})
	
	public JsonObject getAll() {
		dao.beginTransaction();
		List<Aluno> listaDeAlunos = dao.findAll();
		dao.closeTransaction();
		
		final JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		for (Aluno aluno : listaDeAlunos) {
			JsonObjectBuilder b = Json.createObjectBuilder();
			b.add("id", aluno.getId());
			b.add("nome", aluno.getNome());
			arrayBuilder.add(b);
		}
		
		JsonObjectBuilder r = Json.createObjectBuilder();
		r.add("result", arrayBuilder);
		return r.build();
	}


	
	
	
}
