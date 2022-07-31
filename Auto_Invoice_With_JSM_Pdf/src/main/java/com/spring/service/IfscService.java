package com.spring.service;

import java.util.List;

import com.spring.dto.IfscDto;

import com.spring.model.Ifsc;

public interface IfscService {
	public List<IfscDto> getIfsc();
	IfscDto entityToDto(Ifsc ifsc);

}
