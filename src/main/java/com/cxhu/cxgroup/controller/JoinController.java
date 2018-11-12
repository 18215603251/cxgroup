package com.cxhu.cxgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.cxgroup.dao.JoinDao;
import com.cxhu.cxgroup.domain.Join;

/**
 * 加入我们页面控制器
 * @author admin
 */

@Controller
public class JoinController {
	
	@Autowired 
	private JoinDao dao;
	
	@RequestMapping("/getJoinList")
	@ResponseBody
	public Object getJoinList() {
		
		List<Join> all = dao.findAll();
		
		return all;
	}
}
