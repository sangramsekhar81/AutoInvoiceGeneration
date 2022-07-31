package com.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BankDao;
import com.spring.dto.BankDto;
import com.spring.model.Bank;

@Service
@Transactional
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDao bankDao;	

	@Override
	public BankDto entityToDto(Bank bank) {
		BankDto bankDto=new BankDto();
		bankDto.setBankName(bank.getBankName());
		return bankDto;
	}
	@Override
	@Transactional
	public List<BankDto> getBank() {
		
		return bankDao.getBank().stream().map(this::entityToDto).collect(Collectors.toList());
	}

}
