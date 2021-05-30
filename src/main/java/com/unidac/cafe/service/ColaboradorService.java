package com.unidac.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unidac.cafe.mapper.ColaboradorMapper;
import com.unidac.cafe.model.dto.ColaboradorDTO;
import com.unidac.cafe.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	public ColaboradorRepository repositorio;
	
	@Autowired
	private ColaboradorMapper mapper;
	
	@Transactional
	public ColaboradorDTO salvar(ColaboradorDTO dto) {		
		repositorio.salvar(dto.getNome(), dto.getCpf(), dto.getOpcao());
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<ColaboradorDTO> listar() {		
		return mapper.toDto(repositorio.listar());		
	}
	
	@Transactional
	public ColaboradorDTO encontraPorId(Long id) {
		return mapper.toDto(repositorio.encontraPorId(id));				
	}

	@Transactional
	public ColaboradorDTO editar(ColaboradorDTO dto) {		
		repositorio.editar(dto.getNome(), dto.getCpf(), dto.getOpcao(), dto.getId());
		return dto;
	}
	
	@Transactional
	public ColaboradorDTO deletar(Long id) {
		ColaboradorDTO dto = this.encontraPorId(id);
		repositorio.deletar(dto.getId());
		return dto;
	}

}
