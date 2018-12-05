package com.shop.dao;

import java.util.List;

import com.shop.entity.Brand;

public interface BrandMapper {
    int deleteByPrimaryKey(Integer brandID);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer brandID);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
    
    List<Brand> getAllBand();
}