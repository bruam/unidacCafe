package com.unidac.cafe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unidac.cafe.model.dto.ColaboradorDTO;
import com.unidac.cafe.service.ColaboradorService;

@RestController
@RequestMapping(value="/colab")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ColaboradorDTO> salvar(@Valid @RequestBody ColaboradorDTO dto) {
		return ResponseEntity.ok(service.salvar(dto));		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ColaboradorDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ColaboradorDTO> encontraPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.encontraPorId(id));		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ColaboradorDTO> editar(@Valid @RequestBody ColaboradorDTO dto) {
		return ResponseEntity.ok(service.editar(dto));
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ColaboradorDTO> deletar(@PathVariable Long id) {
		return ResponseEntity.ok(service.deletar(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ColaboradorDTO> encontraPorCpf(ColaboradorDTO dto) {
		return ResponseEntity.ok(service.encontraPorCpf(dto.getCpf()));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ColaboradorDTO> encontraPorOpcao(ColaboradorDTO dto) {
		return ResponseEntity.ok(service.encontraPorOpcao(dto.getOpcao()));
	}

}
