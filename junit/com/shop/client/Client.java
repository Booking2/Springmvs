package com.shop.client;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.dao.BankMapper;
import com.shop.entity.Bank;
import com.shop.service.BankService;

public class Client {
   @Test
   public void getbank() {
	   ApplicationContext ctx = new  ClassPathXmlApplicationContext("classpath:applicationContext-mybatis.xml");
	  /* BankMapper bankMapper = (BankMapper)ctx.getBean("bankMapper");
	   Bank bank = bankMapper.selectByPrimaryKey(8);
	   System.out.println(bank.getCustomerName());*/
	   BankService bankService = (BankService) ctx.getBean("bankService");
	   //��һ��������ת�˼۸񣬵ڶ������������ĸ��˻�ת��������������ת���ĸ��˻���
	   bankService.testMoney(new BigDecimal(0), new BigDecimal(1),new BigDecimal(4));
   }
}
