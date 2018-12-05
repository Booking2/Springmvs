package com.shop.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.entity.Bank;
import com.shop.service.BankService;
import com.shop.tools.PageTool;

@Controller
public class BankController {
	   @Autowired
       private BankService bankService;
	   
	   @RequestMapping("/addbank")
	   public String addbank(Bank bank) {
		   bankService.insertSelective(bank);
		   return "msg"; 
	   }
	   
	   @RequestMapping("/getaddBank")
	   public String getaddBank(Model model) {
		   List<Bank> getaddBank = bankService.getaddBank();
		   model.addAttribute("getaddBank",getaddBank);
		   return "index1";
	   }
	   
	   @RequestMapping("/getaddBanks")
	   public String getaddBanks(Integer currentPageNo ,Model model) {
		   if(null == currentPageNo) {
			   currentPageNo = 1; 
		   }
		   int bankSum = bankService.getBankSum();
		   PageTool pageTool = new PageTool();
		   pageTool.setTotalCount(bankSum);
		   pageTool.setCurrentPageNo(currentPageNo);
		   
		   List<Bank> getaddBanks = bankService.getaddBanks(currentPageNo, pageTool.getPageSize());
		   model.addAttribute("getaddBanks", getaddBanks);
		   model.addAttribute("pageTool", pageTool);
		   return "index2"; 
	   }
	   
	   //转账
	   @RequestMapping("/testMoneys")
	   public String testMoneys(BigDecimal currentMoney, BigDecimal formid, BigDecimal id,Model model) {
		   if(currentMoney.compareTo(new BigDecimal(0))<=0) {
			   model.addAttribute("tranErr","<font color='red'>[转账金额不能少于1元]<font>");
		   }else {
			   bankService.testMoney(currentMoney, formid, id);
			   model.addAttribute("tranErr","<font  id='colors'>[转账金额成功]<font>");
		   }
		   return "tranfre";
	   }
	   
	   //500异常处理
	   @ExceptionHandler(RuntimeException.class)
	   public String resourcesExeption(RuntimeException e,HttpServletRequest request) {
		   request.setAttribute("tranErr","<font color='red'>[金额不足,转账失败]<font>");
		   return "tranfre";
	   }
	   
	   //ssm使用Ajax
	   @ResponseBody
		@RequestMapping("/getbankbyid")
	   public Bank getbankbyid(BigDecimal id) {
			Bank  bank  = bankService.getbankbyid(id);
			return bank;
		}
}
