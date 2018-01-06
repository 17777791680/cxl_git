package com.itheima.web.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;
import com.itheima.domain.PageBean;
import com.itheima.service.BookServiceImpl;
import com.itheima.web.filter.BaseServlet;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	public String findByPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum");
		int pageNumber=1;
		if(pageNum!=null&&!"".equals(pageNum)) {
			pageNumber=Integer.parseInt(pageNum);
		}
		int rows=4;
		BookServiceImpl serviceImpl = new BookServiceImpl();
		try {
			PageBean<Book> pb=serviceImpl.findByPage(pageNumber,rows);
			request.setAttribute("page", pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "product_list.jsp";
	}
	public void delBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if(id!=null&&!"".equals(id)) {
			BookServiceImpl serviceImpl = new BookServiceImpl();
			try {
				serviceImpl.delById(id);
				response.sendRedirect(request.getContextPath()+"/BookServlet?methodName=findByPage");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
