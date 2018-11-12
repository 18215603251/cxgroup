package com.cxhu.cxgroup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxhu.cxgroup.domain.Post;

public interface PostDao extends JpaRepository <Post, Integer> {
	
	// 根据关联id查询相应信息
	public List<Post> getByFid(Integer fid);
} 
