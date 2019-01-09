package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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
}