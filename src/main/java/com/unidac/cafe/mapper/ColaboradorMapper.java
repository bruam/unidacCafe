package com.unidac.cafe.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.unidac.cafe.model.Colaborador;
import com.unidac.cafe.model.dto.ColaboradorDTO;

@Component
public class ColaboradorMapper {
	
	public Colaborador toEntity(ColaboradorDTO dto) {
		Colaborador colab = new Colaborador();
		colab.setId(dto.getId());
		colab.setCpf(dto.getCpf());
		colab.setNome(dto.getNome());
		colab.setOpcao(dto.getOpcao());
		return colab;
	}
	
	public ColaboradorDTO toDto(Colaborador colab) {
		ColaboradorDTO dto = new ColaboradorDTO();
		dto.setId(colab.getId());
		dto.setCpf(colab.getCpf());
		dto.setNome(colab.getNome());
		dto.setOpcao(colab.getOpcao());
		return dto;
	}
	
	public List<ColaboradorDTO> toDto(List<Colaborador> listaColab) {
		return listaColab.stream().map(this::toDto).collect(Collectors.toList());
	}

}
