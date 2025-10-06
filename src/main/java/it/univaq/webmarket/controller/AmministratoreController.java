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
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abrah
 */

public class AmministratoreController extends ApplicationBaseController {
    
     @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, TemplateManagerException {
        HttpSession session = SecurityHelpers.checkSession(request);
        if(session==null){
            response.sendRedirect("login?error=3");
            return;
        }
        String azione = request.getParameter("azione");
         if ("gestione utenti".equals(azione)) {
            GestioneUtenti(request, response);
        } else if ("gestione prodotti".equals(azione)) {
           GestioneProdotti(request,response);
        }
        else if ("gestione ordini".equals(azione)) {
           GestioneOrdini(request,response);
        }else{
        action_default(request, response);}
        
    }
    
    private void action_default(HttpServletRequest request, HttpServletResponse response) throws TemplateManagerException, IOException {
        TemplateResult result = new TemplateResult(getServletContext());
        Map<String, Object> datamodel = new HashMap<>();
        HttpSession session = SecurityHelpers.checkSession(request);
        String username = (String) session.getAttribute("username");
        datamodel.put("username", username);
        result.activate("amministratore.ftl.html", datamodel, request, response);

    }

    

    private void GestioneUtenti(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("gestioneUtenti"); 
    }

    private void GestioneProdotti(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void GestioneOrdini(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
