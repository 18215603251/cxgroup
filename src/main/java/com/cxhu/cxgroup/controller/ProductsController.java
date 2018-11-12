package com.cxhu.cxgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.cxgroup.dao.ProductsDao;
import com.cxhu.cxgroup.domain.Products;

/**
 * 集团产业控制器
 * @author admin
 */

@Controller
public class ProductsController {
	
	@Autowired 
	private ProductsDao dao;
	
	@RequestMapping("/getProductsList")
	@ResponseBody
	public Object getProductsList() {
		
		List<Products> all = dao.findAll();
		
		return all;
	}
}
