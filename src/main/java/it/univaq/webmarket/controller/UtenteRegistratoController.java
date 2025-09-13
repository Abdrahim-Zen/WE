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
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abdrahimzeno
 */
public class UtenteRegistratoController extends ApplicationBaseController {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String azione = request.getParameter("azione");
         if ("richiesta".equals(azione)) {
            InviaRichiesta(request, response);
        } else if ("richieste".equals(azione)) {
           MostraRichieste(request,response);
        }
        else if ("prodotti".equals(azione)) {
           MostraProdottiCandidati(request,response);
        }else{
        action_default(request, response);}
    }
    
    

    private void action_default(HttpServletRequest request, HttpServletResponse response) throws TemplateManagerException {
        TemplateResult result = new TemplateResult(getServletContext());
        Map<String, Object> datamodel = new HashMap<>();
        HttpSession session = SecurityHelpers.checkSession(request);
        String username = (String) session.getAttribute("username");
        datamodel.put("username", username);
        result.activate("utenteRegistrato.ftl.html", datamodel, request, response);

    }

    private void InviaRichiesta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("richiestaAcquisto");
    }

    private void MostraRichieste(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("statoRichieste"); 
    }

    private void MostraProdottiCandidati(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("prodottoCandidato"); 
    }

}
