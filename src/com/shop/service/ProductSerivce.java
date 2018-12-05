package com.shop.service;

import java.util.List;

import com.shop.entity.Product;

public interface ProductSerivce {
	//总数
    int getToballist();
    //分页
    List<Product> productList(Integer currentPageNo, Integer pageSize);
    //所有产品
    List<Product> getProductList();
    
    //添加商品
    int insertSelective(Product record);
    
    //回显商品
    Product reviewList(Integer id);
    //修改商品信息
    int updateProduct(Product product);
}
