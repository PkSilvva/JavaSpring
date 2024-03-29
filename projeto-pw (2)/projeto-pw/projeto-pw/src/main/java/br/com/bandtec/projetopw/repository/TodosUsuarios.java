package br.com.bandtec.projetopw.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bandtec.projetopw.controller.Credenciais;
import br.com.bandtec.projetopw.domain.Usuario;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, UUID> {

	@Query("from Usuario")
	boolean contemUsuarioComEssas(Credenciais credenciais);

}
