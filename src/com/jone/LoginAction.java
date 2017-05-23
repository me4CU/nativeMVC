/**
 * 
 */
package com.jone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 *
 */
public class LoginAction implements Action {

	@Override  
    public String execute(HttpServletRequest request,  
            HttpServletResponse response) {  
        String username = request.getParameter("username");  
        String password = request.getParameter("password");  
          
        request.setAttribute("username", username);  
        request.setAttribute("password", password);  
        if (username != null && username.trim().length() != 0   
                && password != null && password.trim().length() != 0) {  
            return "jsp/success.jsp";  
        }  
        return "jsp/login.jsp";  
    }

}
