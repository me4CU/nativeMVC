package com.jone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Action 接口，所有的业务action类都需要实现此接口 
 * execute方法返回view资源的引用字符串，比如“jsp/login.jsp” 
 *  
 * @author Administrator 
 * 
 */  
public interface Action {  
      
    public String execute(HttpServletRequest request, HttpServletResponse response);  
  
}  
