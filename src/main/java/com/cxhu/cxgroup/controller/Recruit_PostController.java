package com.cxhu.cxgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.cxgroup.dao.PostDao;
import com.cxhu.cxgroup.dao.PostRecruitDao;
import com.cxhu.cxgroup.domain.Post;
import com.cxhu.cxgroup.domain.PostRecruit;

/**
 * 加入我们页面的招聘控制器
 * @author admin
 */

@Controller
public class Recruit_PostController {
	
	@Autowired 
	private PostRecruitDao dao;
	@Autowired 
	private PostDao postDao;
	
	@RequestMapping("/getPostList")
	@ResponseBody
	// 查询到所有的招聘类型
	public Object getJoinList() {
		
		List<PostRecruit> all = dao.findAll(); 
		
		return all;
	}
	
	@RequestMapping("/getRelativePostList")
	@ResponseBody
	// 根据招聘类型, 查询到相应的招聘信息
	public Object getRelativePostList(String fid) {
		int parseFid = Integer.parseInt(fid);
		List<Post> all = postDao.getByFid(parseFid);
		return all;
	}
	
}
