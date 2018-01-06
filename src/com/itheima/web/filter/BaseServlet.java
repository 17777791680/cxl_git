package com.itheima.web.filter;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = request.getParameter("methodName");
		if(methodName==null||"".equals(methodName)) {
			methodName="defaultPath";
		}
		Class clazz = this.getClass();
		try {
			Method method=clazz.getMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
				String path=(String)method.invoke(this, request,response);
				if(path!=null&&path!=""){
					request.getRequestDispatcher(path).forward(request, response);;
				}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().print("������������������Զ���ת����ҳ������");
			response.setHeader("refresh", "3;url="+request.getContextPath());
		}
		
		
	}
	public void defaultPath (HttpServletRequest request,HttpServletResponse response) {
		try {
			response.getWriter().print("���ʷ�ʽ���Ϸ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
