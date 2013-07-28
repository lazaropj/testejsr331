package br.com.linkout.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.linkout.modelo.Aluno;
import br.com.linkout.util.FabricaDeConexao;

public class AlunoDAO {
	
	EntityManager em = new FabricaDeConexao().getConexao();

	public List<Aluno> obterTodos() {
		em.getTransaction().begin();
		//implementar uma query aqui...
		return null;
	}

}
