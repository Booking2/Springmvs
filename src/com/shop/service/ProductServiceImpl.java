package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.ProductMapper;
import com.shop.entity.Product;

@Service("productSerivce")
public class ProductServiceImpl implements ProductSerivce {
    
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public int getToballist() {
		// TODO Auto-generated method stub
		return productMapper.getToballist();
	}
	/*======================��Ʒ��Ϣ��ҳ=======================*/
	@Override
	public List<Product> productList(Integer currentPageNo, Integer pageSize) {
		Integer currentPageNos = (currentPageNo - 1)*pageSize;
		return productMapper.productList(currentPageNos, pageSize);
	}
	/*======================��ʾ������Ʒ��Ϣ=======================*/
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productMapper.getProductList();
	}
	/*======================�����Ʒ��Ʒ=======================*/
	@Override
	public int insertSelective(Product record) {
		
		return productMapper.insertSelective(record);
	}
    /*======================������Ʒ=======================*/
	@Override
	public Product reviewList(Integer id) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(id);
	}
    /*======================�޸���Ʒ��Ϣ=======================*/
	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(product);
	}

}
