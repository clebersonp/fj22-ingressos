package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public enum TipoDeIngresso {
	
	INTEIRO(new SemDesconto(), "Normal"),
	ESTUDANTE(new DescontoParaEstudantes(), "Desconto Estudante"),
	BANCO(new DescontoParaBancos(), "Desconto Banco");
	
	private final Desconto desconto;
	private final String descricao;
	
	TipoDeIngresso(Desconto desconto, String descricao) {
		this.desconto = desconto;
		this.descricao = descricao;
	}
	
	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDescontoSobre(valor);
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
