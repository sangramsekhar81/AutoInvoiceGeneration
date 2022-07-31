package com.spring.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.IfscDao;
import com.spring.dto.IfscDto;
import com.spring.model.Ifsc;

@Service
@Transactional
public class IfscServiceImpl implements IfscService {
	
	@Autowired
	private IfscDao ifscDao;

	@Override
	@Transactional
	public IfscDto entityToDto(Ifsc ifsc) {
		IfscDto ifc=new IfscDto();
		ifc.setIfscCode(ifsc.getIfscCode());
		return ifc;
	}
	@Override
	@Transactional
	public List<IfscDto> getIfsc() {
		
		return ifscDao.getIfsc().stream().map(this::entityToDto).collect(Collectors.toList());
	}

}
