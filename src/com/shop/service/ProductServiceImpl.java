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
	/*======================商品信息分页=======================*/
	@Override
	public List<Product> productList(Integer currentPageNo, Integer pageSize) {
		Integer currentPageNos = (currentPageNo - 1)*pageSize;
		return productMapper.productList(currentPageNos, pageSize);
	}
	/*======================显示所有商品信息=======================*/
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productMapper.getProductList();
	}
	/*======================添加商品商品=======================*/
	@Override
	public int insertSelective(Product record) {
		
		return productMapper.insertSelective(record);
	}
    /*======================回显商品=======================*/
	@Override
	public Product reviewList(Integer id) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(id);
	}
    /*======================修改商品信息=======================*/
	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(product);
	}

}
