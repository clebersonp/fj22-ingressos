package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public interface Desconto {
	BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);
}
