package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Book;
import com.itheima.domain.PageBean;
import com.itheima.util.C3P0Util;

public class BookDaoImpl {

	public int getTotalRecord() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select count(*) from books";
		Long query = (Long) qr.query(sql,new ScalarHandler());
		return query.intValue();
	}

	public List<Book> findByPage(PageBean<Book> pb) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from books limit ?,?";
		List<Book> list = qr.query(sql, new BeanListHandler<Book>(Book.class),pb.getStartIndex(),pb.getPageSize());
		return list;
	}

	public void delById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="delete from books where id=?";
		qr.update(sql,id);
	}
	

}
