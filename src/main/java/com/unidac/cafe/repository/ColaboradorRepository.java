package com.unidac.cafe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unidac.cafe.model.Colaborador;
import com.unidac.cafe.model.dto.ColaboradorDTO;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
	
	
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
