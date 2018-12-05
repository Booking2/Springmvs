package com.shop.service;

import java.math.BigDecimal;
import java.util.List;

import com.shop.entity.Bank;

public interface BankService {
	int insertSelective(Bank record);
	
	List<Bank> getaddBank();
	
	List<Bank> getaddBanks(Integer currentPageNo,Integer pageSize);
	
	int getBankSum();
	
	void testMoney(BigDecimal currentMoney,BigDecimal formid,BigDecimal id);
	
	//ssm µœ÷Ajax
    Bank  getbankbyid(BigDecimal id);
}
