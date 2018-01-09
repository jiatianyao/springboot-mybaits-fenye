package com.zwjf.controller;


import com.github.pagehelper.PageInfo;
import com.zwjf.domain.Product;
import com.zwjf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;







    @RequestMapping("/product")
    public String index(Model model,  @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Product> products = productService.selectProductByPage(pageNum, pageSize);
        PageInfo<Product> productPageInfo = new PageInfo<>(products);
        //获得当前页
        model.addAttribute("pageNum", productPageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", productPageInfo.getPageSize());
        model.addAttribute("isFirstPage", productPageInfo.isIsFirstPage());

        //是否是第一页
        model.addAttribute("hasPreviousPage", productPageInfo.isHasPreviousPage());

        //获得总页数
        model.addAttribute("totalPages", productPageInfo.getPages());
        model.addAttribute("firstPage", productPageInfo.getFirstPage());
        //是否是最后一页
        model.addAttribute("hasNextPage", productPageInfo.isHasNextPage());
        model.addAttribute("lastPage", productPageInfo.getLastPage());
        model.addAttribute("isLastPage", productPageInfo.isIsLastPage());
        model.addAttribute("Product", productPageInfo.getList());

        return "product";
    }




}
