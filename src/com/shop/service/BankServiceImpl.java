package com.shop.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dao.BankMapper;
import com.shop.entity.Bank;
import com.shop.service.BankService;

@Service("bankService")
public class BankServiceImpl implements BankService {
    
	@Autowired
	private BankMapper bankMapper;
	@Override
	public int insertSelective(Bank record) { 
		return bankMapper.insertSelective(record);
	}
	@Override
	public List<Bank> getaddBank() {
		// TODO Auto-generated method stub
		return bankMapper.getaddBank();
	}
	
	
	@Override
	public List<Bank> getaddBanks(Integer currentPageNo, Integer pageSize) {
		Integer currentPageNos = (currentPageNo - 1)*pageSize;
		return bankMapper.getaddBanks(currentPageNos, pageSize);
	}
	@Override
	public int getBankSum() {
		// TODO Auto-generated method stub
		return bankMapper.getBankSum();
	}
	@Override
	@Transactional
	public void testMoney(BigDecimal currentMoney, BigDecimal formid, BigDecimal id) {
	       bankMapper.addMoney(currentMoney, id);
		   bankMapper.reduceMoney(currentMoney, formid); 
	}
	@Override
	public Bank getbankbyid(BigDecimal id) {
		Bank  bank  = bankMapper.getbankbyid(id);
		return bank;
	}

}
