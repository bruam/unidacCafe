package com.unidac.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unidac.cafe.exceptions.BusinessException;
import com.unidac.cafe.exceptions.NotFoundException;
import com.unidac.cafe.mapper.ColaboradorMapper;
import com.unidac.cafe.model.Colaborador;
import com.unidac.cafe.model.dto.ColaboradorDTO;
import com.unidac.cafe.repository.ColaboradorRepository;
import com.unidac.cafe.util.MessageUtils;

@Service
public class ColaboradorService {
	
	@Autowired
	public ColaboradorRepository repositorio;
	
	@Autowired
	private ColaboradorMapper mapper;
	
	@Transactional
	public ColaboradorDTO salvar(ColaboradorDTO dto) {		
		Optional<Colaborador> optionalColabCpf = repositorio.encontraPorCpf(dto.getCpf());
		Optional<Colaborador> optionalColabOpcao = repositorio.encontraPorOpcao(dto.getOpcao());
		if(optionalColabCpf.isPresent()) {
			throw new BusinessException(MessageUtils.COLABORADOR_ALREADY_EXISTS);
		}
		if(optionalColabOpcao.isPresent()) {
			throw new BusinessException(MessageUtils.OPCAO_ALREADY_EXISTS);
		}
		Colaborador colab = mapper.toEntity(dto);
		repositorio.salvar(colab.getNome(), colab.getCpf(), colab.getOpcao());
		return mapper.toDto(colab);
	}
	
	@Transactional(readOnly = true)
	public List<ColaboradorDTO> listar() {		
		return mapper.toDto(repositorio.listar());		
	}
	
	@Transactional
	public ColaboradorDTO encontraPorId(Long id) {		
		try {
			return mapper.toDto(repositorio.encontraPorId(id));
		} catch (Exception e) {
			throw new NotFoundException();
		}						
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
