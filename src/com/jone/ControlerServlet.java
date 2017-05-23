package com.jone;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlerServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public ControlerServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);  
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathName = req.getServletPath();  
        System.out.println("pathName:" + pathName);  
          
        int index = pathName.indexOf(".");  
        String actionName = pathName.substring(1,index);  
        System.out.println("actionName:" + actionName);  
          
        String actionClass = getInitParameter(actionName);  
        System.out.println("actionClass:" + actionClass);  
          
        if (null == actionName) {
        	req.getRequestDispatcher("error.jsp").forward(req, resp);  
		}
        Action action = ActionFactory.getAction(actionName);  
        
        // eCharts 后台获取数据 ----------------------------Start
        
        // --------------------------------------------End
        
        if (null == action) {
        	req.getRequestDispatcher("error.jsp").forward(req, resp);  
		}
        String viewUrl = action.execute(req, resp);  
        if (viewUrl == null) {  
            req.getRequestDispatcher("error.jsp").forward(req, resp);  
        } else {  
            req.getRequestDispatcher(viewUrl).forward(req, resp);  
        }
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		System.out.println("init() 开始。。。。。。。");
	}

}
