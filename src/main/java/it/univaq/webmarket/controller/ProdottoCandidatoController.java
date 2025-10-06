/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.univaq.webmarket.controller;

import it.univaq.webmarket.application.ApplicationBaseController;
import it.univaq.webmarket.data.dao.impl.WebMarketDataLayer;
import it.univaq.webmarket.data.model.ProdottoCandidato;
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
import java.util.List;
import java.util.Map;

/**
 *
 * @author abdrahimzeno
 */
public class ProdottoCandidatoController extends ApplicationBaseController {

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
        if ("accetta".equals(azione)) {
            accettazione(request, response);
        } else if ("rifiuta".equals(azione)) {
           rifiutato(request,response);
        }
        WebMarketDataLayer dl = (WebMarketDataLayer) request.getAttribute("datalayer");
        
        Integer idUtente = (Integer) session.getAttribute("userid");
        List<ProdottoCandidato> prodotti = dl.getProdottoCandidatoDAO().getProdottiCandidatiByUserID(idUtente);
        Map<String, Object> datamodel = new HashMap<>();
        datamodel.put("prodotti", prodotti);
        TemplateResult result = new TemplateResult(getServletContext());
        result.activate("prodottoCandidato.ftl.html", datamodel, request, response);

    }

    private void accettazione(HttpServletRequest request, HttpServletResponse response) {
       
    }

    private void rifiutato(HttpServletRequest request, HttpServletResponse response) {
      
    }
}
