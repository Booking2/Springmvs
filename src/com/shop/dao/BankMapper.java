package com.shop.dao;
 

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.entity.Bank;

public interface BankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bank record);
     
    int insertSelective(Bank record);

    Bank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
    
    List<Bank> getaddBank();
    
    //getaddBank 
    List<Bank> getaddBanks(@Param("stratIndex") Integer stratIndex,@Param("pageSize") Integer pageSize);
    
    int getBankSum();
    
    //º”«Æ
    int addMoney(@Param("currentMoney") BigDecimal currentMoney,@Param("id") BigDecimal id);
    
    //ºı«Æ
    int reduceMoney(@Param("currentMoney") BigDecimal currentMoney,@Param("formid") BigDecimal formid);

    //ssm µœ÷Ajax
    Bank  getbankbyid(@Param("id") BigDecimal id);
}