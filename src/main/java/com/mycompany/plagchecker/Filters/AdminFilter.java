/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Filters;

import com.mycompany.plagchecker.Model.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yusuf Can Çelik
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {
    
    public AdminFilter() {
    }    
    
        public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        try {

                HttpServletRequest reqt = (HttpServletRequest) request;
                HttpServletResponse resp = (HttpServletResponse) response;
                HttpSession ses = reqt.getSession(false);
            if ((ses != null && ses.getAttribute("user") != null)){
		User u = (User)ses.getAttribute("user");
                if(u.getRole().getName().equals("admin")){
                    chain.doFilter(request, response);
                }else{
                    
                    resp.sendRedirect(reqt.getContextPath() + "/index.xhtml");
                    
                }
            }else{
		resp.sendRedirect(reqt.getContextPath() + "/login/login.xhtml");
            }
        } catch (Exception e) {
                System.out.println(e.getMessage());
	} 
    }


    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        }

}
