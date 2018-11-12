package com.cxhu.cxgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.cxgroup.dao.AbountGroupDao;
import com.cxhu.cxgroup.domain.About_group;

/**
 * 半天集团页面控制器
 * @author admin
 */

@Controller
public class AbountGroupController {

	@Autowired
	private AbountGroupDao dao;
	
	@RequestMapping(value="/getAboutList", method=RequestMethod.GET)	
	@ResponseBody
	public Object getNavInfo() {
		
		List<About_group> all_list = dao.findAll();
		
		return all_list;
	}
}
