package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {

	// o <T> antes do retorno é para dizer que somente esse metodo sera generico e nao toda a classe
	public <T> Optional<T> request(Filme filme, Class<T> tClass) {
		RestTemplate client = new RestTemplate();
		
		String titulo = filme.getNome().replace(" ", "+");
		
		String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s", titulo);
		
		try {
			T response = client.getForObject(url, tClass);
			return Optional.ofNullable(response);
		} catch (RestClientException e) {
			return Optional.empty();
		}
	}
	
}
