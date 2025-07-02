package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Product;

public class ProductDao {
	
	public List<Product> searchProduct(Product param) {
		// 데이터베이스와 연결
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Product> list = session.selectList("com.gn.mapper.ProductMapper.searchProduct", param);
		session .close();
		return list;
	}

}
