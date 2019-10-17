package br.com.bandtec.projetopw.domain;

import javax.persistence.Embeddable;

@Embeddable
public class RA {

	private long numero;
	
	protected RA() {}
	
	public RA(long numero) {
		this.numero = numero;
	}

}
