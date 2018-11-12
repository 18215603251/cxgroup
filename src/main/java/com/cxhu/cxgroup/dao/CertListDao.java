package com.cxhu.cxgroup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cxhu.cxgroup.domain.CertList;

public interface CertListDao extends JpaRepository<CertList, Integer>{
	
	// 分页查询
	@Query(nativeQuery = true, value = "select * from cert_list limit ?1, ?2")
	public List<CertList> getCertDivide(int startIndex, int limit); 

}
