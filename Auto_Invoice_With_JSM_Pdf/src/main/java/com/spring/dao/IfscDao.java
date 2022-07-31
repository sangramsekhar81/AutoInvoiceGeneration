package com.spring.dao;

import java.util.List;


import com.spring.dto.IfscDto;

import com.spring.model.Ifsc;

public interface IfscDao {

	public List<Ifsc> getIfsc();
	public List<IfscDto> getIfscDto();
	public IfscDto entityToDto(Ifsc ifsc);
}
