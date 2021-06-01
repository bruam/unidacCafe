package com.unidac.cafe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unidac.cafe.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
	
	@Query(value = "SELECT * FROM colaborador WHERE cpf LIKE :cpf",
			nativeQuery = true)
	Optional<Colaborador> encontraPorCpf(String cpf);
	
	@Query(value = "SELECT * FROM colaborador WHERE opcao LIKE :opcao",
			nativeQuery = true)
	Optional<Colaborador> encontraPorOpcao(String opcao);

	@Query(value = "SELECT * FROM colaborador",
			 nativeQuery = true) 
	  List<Colaborador> listar();
	  
	  @Query(value = "SELECT * FROM colaborador WHERE colaborador.id = :id",
			 nativeQuery = true) 
	  Colaborador encontraPorId(Long id);
	  
	  @Modifying
	  @Query(value = "INSERT INTO colaborador (nome, cpf, opcao) VALUES (:nome, :cpf, :opcao)",
			 nativeQuery = true) 
	  void salvar(String nome, String cpf, String opcao);
	  
	  @Modifying
	  @Query(value = "UPDATE colaborador SET nome = :nome, cpf = :cpf, opcao = :opcao WHERE id = :id",
			 nativeQuery = true) 
	  void editar(String nome, String cpf, String opcao, Long id);
	  
	  @Modifying
	  @Query(value = "DELETE FROM colaborador WHERE id = :id",
			 nativeQuery = true)
	  void deletar(Long id);
}
