package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class DescontoParaEstudantes implements Desconto {

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(this.cinquentaPorCentoSobre(precoOriginal));
	}
	
	private BigDecimal cinquentaPorCentoSobre(BigDecimal precoOriginal) {
		return precoOriginal.multiply(new BigDecimal("0.5"));
	}
}
