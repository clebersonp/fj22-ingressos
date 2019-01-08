package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {

	private Integer id;
	private final LocalTime horario;
	private final Sala sala;
	private final Filme filme;

	public Sessao(LocalTime horario, Sala sala, Filme filme) {
		super();
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
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
}
