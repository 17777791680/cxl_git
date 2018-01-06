package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.BookDaoImpl;
import com.itheima.domain.Book;
import com.itheima.domain.PageBean;

public class BookServiceImpl {

	public PageBean<Book> findByPage(int pageNumber, int rows) throws SQLException {
		// TODO Auto-generated method stub
		PageBean<Book> pb = new PageBean<Book>();
		pb.setPageNumber(pageNumber);
		pb.setPageSize(rows);
		BookDaoImpl daoImpl = new BookDaoImpl();
		int totalRecord=daoImpl.getTotalRecord();
		pb.setTotalRecord(totalRecord);
		List<Book> result=daoImpl.findByPage(pb);
		pb.setResult(result);
		return pb;
	}

	public void delById(String id) throws SQLException {
		// TODO Auto-generated method stub
		BookDaoImpl daoImpl = new BookDaoImpl();
		daoImpl.delById(id);
	}
	
	
}
