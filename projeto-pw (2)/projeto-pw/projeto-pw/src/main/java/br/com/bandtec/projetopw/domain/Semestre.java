package br.com.bandtec.projetopw.domain;

public enum Semestre {

	PRIMEIRO,
	SEGUNDO,
	TERCEIRO,
	QUARTO,;

	public static final Semestre lerProximo(Semestre semestre) {
		int indice = semestre.ordinal();
		int novoIndice = indice + 1;
		Semestre[] semestres = Semestre.values();
		novoIndice %= semestres.length;
		return semestres[novoIndice];
	}
}
