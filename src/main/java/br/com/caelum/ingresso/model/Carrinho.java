package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope // o spring ira gerenciar esse carinho durante o scopo da sessao
public class Carrinho {

	private List<Ingresso> ingressos = new ArrayList<>();
	
	public void add(Ingresso ingresso) {
		ingressos.add(ingresso);
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	public boolean isSelecionado(Lugar lugar) {
		return this.ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
	}
	
	public BigDecimal getTotal() {
		return this.ingressos.stream().map(Ingresso::getPreco).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}
	
	public Compra toCompra() {
		return new Compra(ingressos);
	}
}
