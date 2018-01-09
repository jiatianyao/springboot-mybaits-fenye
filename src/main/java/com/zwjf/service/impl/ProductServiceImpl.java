package com.zwjf.service.impl;

import com.github.pagehelper.PageHelper;


import com.zwjf.config.PageBean;
import com.zwjf.dao.ProductDao;
import com.zwjf.domain.Product;
import com.zwjf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl extends Product implements ProductService
{
        @Autowired
        ProductDao productDao;


        @Override
        public List<Product> selectProductByPage(int currentPage, int pageSize) {
                //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
                PageHelper.startPage(currentPage, pageSize);

                List<Product> allProducts = productDao.selectProductByPage();        //全部商品
                int countNums = productDao.countProduct();            //总记录数
                PageBean<Product> pageData = new PageBean<>(currentPage, pageSize, countNums);
                pageData.setItems(allProducts);
                return pageData.getItems();
        }
}
