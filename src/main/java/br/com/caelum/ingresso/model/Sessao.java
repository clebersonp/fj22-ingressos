package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sessao {

	@Id
	@GeneratedValue
	private Integer id;
	
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;

	private BigDecimal preco;
	
	@OneToMany(mappedBy = "sessao", fetch = FetchType.EAGER)
	private Set<Ingresso> ingressos = new HashSet<>();
	
	/**
	 * Uso para o hibernate
	 */
	public Sessao() {}
	
	public Sessao(LocalTime horario, Sala sala, Filme filme) {
		super();
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public LocalTime getHorarioTermino() {
		return this.horario.plusMinutes(this.filme.getDuracao().toMinutes());
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}
	
	public Sala getSala() {
		return sala;
	}

	public Filme getFilme() {
		return filme;
	}
	
	public BigDecimal getPreco() {
		return this.preco.setScale(2, RoundingMode.HALF_UP);
	}
	
	public Map<String, List<Lugar>> getMapaDeLugares() {
		if (this.sala != null) {
			return this.sala.getMapaDeLugares();
		}
		return Collections.emptyMap();
	}

	public Set<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Set<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public boolean isDisponivel(Lugar lugarSelecionado) {
		return this.ingressos.stream()
				.map(Ingresso::getLugar)
				.noneMatch(lugar -> lugar.equals(lugarSelecionado));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		return true;
	}
}
