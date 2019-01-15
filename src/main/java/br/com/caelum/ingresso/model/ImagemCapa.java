package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// essa classe pega somente a imagem de capa do filme
public class ImagemCapa {
	
	@JsonProperty("Poster")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
