package com.shop.service;

import java.util.List;

import com.shop.entity.Product;

public interface ProductSerivce {
	//����
    int getToballist();
    //��ҳ
    List<Product> productList(Integer currentPageNo, Integer pageSize);
    //���в�Ʒ
    List<Product> getProductList();
    
    //�����Ʒ
    int insertSelective(Product record);
    
    //������Ʒ
    Product reviewList(Integer id);
    //�޸���Ʒ��Ϣ
    int updateProduct(Product product);
}
