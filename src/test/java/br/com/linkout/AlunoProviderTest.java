package br.com.linkout;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import br.com.linkout.DAO.AlunoDAO;
import br.com.linkout.modelo.Aluno;

public class AlunoProviderTest {

	@Test
	public void test() {
		assertNull(null);
	}
	
	public List<Aluno> obterAlunos(){
		AlunoDAO dao = new AlunoDAO();
		dao.beginTransaction();
		List<Aluno> listaDeAlunos = dao.findAll();
		dao.closeTransaction();
		return listaDeAlunos;
	}

}
