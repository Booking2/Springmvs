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
    //商品总数
    int getToballist();
    //分页
    List<Product> productList(@Param("stratIndex") Integer stratIndex,@Param("pageSize") Integer pageSize);
    //所有产品
    List<Product> getProductList();
}