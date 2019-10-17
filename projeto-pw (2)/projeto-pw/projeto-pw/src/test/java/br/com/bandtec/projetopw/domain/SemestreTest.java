package br.com.bandtec.projetopw.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SemestreTest {
	
	@Test
	public void proximoSemestre() {
		assertEquals(Semestre.SEGUNDO, Semestre.lerProximo(Semestre.PRIMEIRO));
		assertEquals(Semestre.TERCEIRO, Semestre.lerProximo(Semestre.SEGUNDO));
		assertEquals(Semestre.QUARTO, Semestre.lerProximo(Semestre.TERCEIRO));
		assertEquals(Semestre.PRIMEIRO, Semestre.lerProximo(Semestre.QUARTO));
	}
}
