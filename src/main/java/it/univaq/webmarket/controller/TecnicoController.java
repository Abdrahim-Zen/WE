/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.univaq.webmarket.controller;

import it.univaq.webmarket.application.ApplicationBaseController;
import it.univaq.webmarket.framework.security.SecurityHelpers;
import it.univaq.webmarket.framework.view.TemplateManagerException;
import it.univaq.webmarket.framework.view.TemplateResult;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdrahimzeno
 */

public class TecnicoController extends ApplicationBaseController {
    
     @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
           
           HttpSession session = SecurityHelpers.checkSession(request);
        if(session==null){
            response.sendRedirect("login?error=3");
            return;
        }
           String username = (String) session.getAttribute("username");
           request.setAttribute("username", username);
            action_default(request,response);
    }

 

    private void action_default(HttpServletRequest request, HttpServletResponse response) throws TemplateManagerException {
        TemplateResult result = new TemplateResult(getServletContext());
        Map<String, Object> datamodel = new HashMap<>();
        HttpSession session = SecurityHelpers.checkSession(request);
        String username = (String) session.getAttribute("username");
        datamodel.put("username", username);
        result.activate("tecnico.ftl.html", datamodel, request, response);
    }

   

}
