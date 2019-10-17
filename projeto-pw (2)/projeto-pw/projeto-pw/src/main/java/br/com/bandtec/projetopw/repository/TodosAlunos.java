package br.com.bandtec.projetopw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.domain.Aluno;
import br.com.bandtec.projetopw.domain.RA;

import java.util.UUID;

@Repository
public interface TodosAlunos extends JpaRepository<Aluno, UUID> {
	@Query("from Aluno")
	Aluno comRA(RA ra);
}
