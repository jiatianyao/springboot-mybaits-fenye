package com.zwjf.dao;


import com.github.pagehelper.Page;
import com.zwjf.domain.Product;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductDao
{



        List<Product> selectProductByPage();
//        Page<Product> findAll(Pageable pageable);
        int countProduct();
}
