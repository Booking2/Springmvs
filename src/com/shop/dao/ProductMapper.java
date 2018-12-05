package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    //��Ʒ����
    int getToballist();
    //��ҳ
    List<Product> productList(@Param("stratIndex") Integer stratIndex,@Param("pageSize") Integer pageSize);
    //���в�Ʒ
    List<Product> getProductList();
}