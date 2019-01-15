package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Sessao sessao) {
		this.entityManager.persist(sessao);
	}
	
	public List<Sessao> buscaoSessoesDaSala(Sala sala) {
		return this.entityManager.createQuery("select s from Sessao s where s.sala = :sala", Sessao.class)
				.setParameter("sala", sala)
				.getResultList();
	}
	
	public List<Sessao> buscaSessoesDo(Filme filme) {
		return this.entityManager.createQuery("select s from Sessao s where s.filme = :filme", Sessao.class)
				.setParameter("filme", filme)
				.getResultList();
	}

	public Sessao findOne(Integer id) {
		/*return this.entityManager.createQuery("select s from Sessao s where s.id = :id", Sessao.class)
				.setParameter("id", id)
				.getSingleResult();
				*/
		return this.entityManager.find(Sessao.class, id);
	}
}