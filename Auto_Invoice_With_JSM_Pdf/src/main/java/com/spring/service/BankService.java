package com.spring.service;

import java.util.List;

import com.spring.dto.BankDto;
import com.spring.model.Bank;



public interface BankService {
	public List<BankDto> getBank();
	BankDto entityToDto(Bank bank);

}
