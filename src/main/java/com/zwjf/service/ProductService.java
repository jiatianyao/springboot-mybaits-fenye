package com.zwjf.service;


import com.zwjf.domain.Product;

import java.util.List;

public interface ProductService
{


        List<Product> selectProductByPage(int currentPage, int pageSize);
}
