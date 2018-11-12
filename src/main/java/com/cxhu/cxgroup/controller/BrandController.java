package com.cxhu.cxgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.cxgroup.dao.BrandDao;
import com.cxhu.cxgroup.domain.Brand;

/**
 * 品牌中心页面控制器
 * @author admin
 */

@Controller
public class BrandController {
	
	@Autowired 
	private BrandDao dao;
	
	@RequestMapping("/getBrandList")
	@ResponseBody
	public Object getProductsList() {
		
		List<Brand> all = dao.findAll();
		
		return all;
	}
}
