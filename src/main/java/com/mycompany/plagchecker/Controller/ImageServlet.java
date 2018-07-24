/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.plagchecker.Controller;

import com.mycompany.plagchecker.Model.Settings;
import com.mycompany.plagchecker.queries.DataQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yusuf Can Çelik
 */
@WebServlet(name = "ImageServlet", urlPatterns = {"/logo"})
public class ImageServlet extends HttpServlet {
    
private DataQuery dataquery = new DataQuery();

   private Settings s;
   
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            byte[] imageBytes = null;
            s = dataquery.findSettingsById();
            imageBytes = s.getImage();
            resp.getOutputStream().write(imageBytes);
            resp.getOutputStream().close();
             
        } catch (Exception e) {
            // Display error message
            resp.getWriter().write(e.getMessage());
            resp.getWriter().close();
        }
         
    }   
}
