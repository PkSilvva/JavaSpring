package br.com.bandtec.projetopw.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.bandtec.projetopw.domain.Aluno;
import br.com.bandtec.projetopw.domain.RA;
import br.com.bandtec.projetopw.domain.Semestre;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
//@Commit // usar caso queira ver o registro na base, após rodar algum teste.
public class TodosAlunosTest {
	
	@Autowired
	private TodosAlunos todosAlunos;
	
	private Aluno alunoDoPrimeiroSemestre;
	private RA ra;
	
	@Before
	public void rodarAntesDeCadaTeste() {
		ra = new RA(102050);
		alunoDoPrimeiroSemestre = new Aluno("Pikachu", ra);
		
		todosAlunos.save(alunoDoPrimeiroSemestre);
	}
	
	@Test
	public void persistirUmAluno() {
		Aluno alunoPersistido = todosAlunos.getOne(alunoDoPrimeiroSemestre.getId());
		
		assertEquals(alunoDoPrimeiroSemestre, alunoPersistido);
	}
	
	@Test
	public void buscarAlunoPorRA() {
		Aluno alunoEncontrado = todosAlunos.comRA(ra);
		
		assertEquals(alunoDoPrimeiroSemestre, alunoEncontrado);
	}
	
	@Test
	public void atualizarAluno() {
		Aluno alunoQuePassouDeAno = todosAlunos.getOne(alunoDoPrimeiroSemestre.getId());
		
		alunoQuePassouDeAno.passarDeSemestre();
		
		todosAlunos.save(alunoQuePassouDeAno);
		
		Aluno alunoDoSegundoSemestre = todosAlunos.getOne(alunoQuePassouDeAno.getId());
		
		assertEquals(Semestre.SEGUNDO, alunoDoSegundoSemestre.lerSemestreAtual());
	}
	
	@Test
	public void removerAluno() {
		todosAlunos.delete(alunoDoPrimeiroSemestre);
		
		boolean alunoExiste = todosAlunos.existsById(alunoDoPrimeiroSemestre.getId());
		
		assertFalse(alunoExiste);
	}
}
