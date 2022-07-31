package com.spring.dao;

import java.util.List;

import com.spring.dto.BankDto;
import com.spring.dto.CustomerDetailsDto;
import com.spring.model.Bank;
import com.spring.model.CustomerDetails;

public interface BankDao {
	public List<Bank> getBank();
	public List<BankDto> getBankDto();
	public BankDto entityToDto(Bank banko);

}
