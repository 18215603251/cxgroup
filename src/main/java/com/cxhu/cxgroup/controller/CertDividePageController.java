package com.cxhu.cxgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.cxgroup.dao.CertListDao;
import com.cxhu.cxgroup.domain.CertList;
import com.cxhu.cxgroup.service.DivideCertPageService;

/**
 * 关于集团页面, 对荣誉证书进行分页
 * @author admin
 */

@Controller
public class CertDividePageController {
	@Autowired
	private CertListDao dao;

	@RequestMapping(value="/getCertDivideList")
	@ResponseBody
	public Object getCertDivideList(String pageCount, String pageIndex) {
		
		/*处理传递过来的数据*/
		if(pageIndex == null || pageCount == null) {
			return null;
		}
			
		int onePageCount = 0;			// 查询出记录总数
		int currentPageIndex = 0;		// 第几页
		try {
			onePageCount = Integer.parseInt(pageCount);
			currentPageIndex = Integer.parseInt(pageIndex);
		} catch (Exception e) {
			return null;
		}
		
		// 查询出记录总数
		long count = dao.count();

		/******************* 创建pageBean对象 *******************/
		DivideCertPageService pageBean = new DivideCertPageService(currentPageIndex, onePageCount, count);

		// 查询所需的内容
		List<CertList> certDivide = dao.getCertDivide(pageBean.getStartIndex(), pageBean.getOnePageSize());
		pageBean.setCerts(certDivide);

		return pageBean;
	}
}
