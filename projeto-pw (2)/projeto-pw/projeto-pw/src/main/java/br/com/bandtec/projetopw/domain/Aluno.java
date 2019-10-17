package br.com.bandtec.projetopw.domain;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name="Aluno")
public class Aluno {

	@Id
	@GeneratedValue
	private UUID id;
	
	private String nome;
	
	private RA ra;
	
	@Enumerated(EnumType.STRING)
	private Semestre semestre;
	
	protected Aluno() {}
	
	public Aluno(String nome, RA ra) {
		this.nome = nome;
		this.ra = ra;
		this.semestre = Semestre.PRIMEIRO;
	}

	public UUID getId() {
		return id;
	}

	public void passarDeSemestre() {
		this.semestre = Semestre.lerProximo(this.semestre);
	}

	public Semestre lerSemestreAtual() {
		return semestre;
	}
}
