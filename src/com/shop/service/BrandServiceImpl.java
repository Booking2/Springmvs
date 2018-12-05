package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.shop.dao.BrandMapper;
import com.shop.entity.Brand;

@Service("brandService")
public class BrandServiceImpl implements BrandService {
    
	@Autowired
	private BrandMapper brandMapper;
	
	@Override
	public List<Brand> getAllBand() {
		// TODO Auto-generated method stub
		return brandMapper.getAllBand();
	}

}
