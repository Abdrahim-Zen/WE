/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.univaq.webmarket.controller;

import it.univaq.webmarket.application.ApplicationBaseController;
import it.univaq.webmarket.data.dao.impl.WebMarketDataLayer;
import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.SpecificaCategoria;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.data.model.ValoreSpecificaRichiesta;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.security.SecurityHelpers;
import it.univaq.webmarket.framework.view.TemplateManagerException;
import it.univaq.webmarket.framework.view.TemplateResult;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abdrahimzeno
 */
public class RichiestaAcquistoController extends ApplicationBaseController {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = SecurityHelpers.checkSession(request);
        if(session==null){
            response.sendRedirect("login?error=3");
            return;
        }
        if (request.getParameter("richiestaAcquisto") != null) {
            invioRichiesta(request, response);
        }

        WebMarketDataLayer dl = (WebMarketDataLayer) request.getAttribute("datalayer");
        request.setAttribute("error", request.getParameter("error"));

        List<Categoria> categorie = dl.getCategoriaDAO().getAllCategorie();
        Map<String, List<SpecificaCategoria>> mappaSpecifiche = new HashMap<>();

        for (Categoria cat : categorie) {
            List<SpecificaCategoria> specs = dl.getSpecificaCategoriaDAO().getListSpecificaCategoria(cat.getKey());
            mappaSpecifiche.put(String.valueOf(cat.getKey()), specs);
        }

        Map<String, Object> datamodel = new HashMap<>();
        datamodel.put("categorie", categorie);
        datamodel.put("specificheMap", mappaSpecifiche);
        TemplateResult result = new TemplateResult(getServletContext());
        result.activate("richiestaAcquisto.ftl.html", datamodel, request, response);

    }

    private void invioRichiesta(HttpServletRequest request, HttpServletResponse response) throws DataException, IOException, TemplateManagerException {
        try {
            
        
        WebMarketDataLayer dl = (WebMarketDataLayer) request.getAttribute("datalayer");

        HttpSession session = SecurityHelpers.checkSession(request);
        Integer idUtente = (Integer) session.getAttribute("userid");

        String note = request.getParameter("note");
        Double importo = Double.valueOf(request.getParameter("importo"));
        Integer categoriaId = Integer.valueOf(request.getParameter("categoria"));
        Categoria r = dl.getCategoriaDAO().getCategoriabyID(categoriaId);
        UtenteRegistrato t = dl.getUtenteRegistratoDAO().getUtente(idUtente);
        RichiestaAcquisto x = dl.getRichiestaAcquistoDAO().createRichiesta();
        x.setUtenteRegistrato(t);
        x.setCategorai(r);
        x.setImporto(importo);
        x.setDataInserimento(new java.sql.Timestamp(System.currentTimeMillis()));
        x.setNote(note);
        dl.getRichiestaAcquistoDAO().storeRichiestaAcquisto(x);

        List<SpecificaCategoria> specifiche = dl.getSpecificaCategoriaDAO().getListSpecificaCategoria(r.getKey());
        for (SpecificaCategoria spec : specifiche) {
            String valoreInput = request.getParameter("specifiche_" + spec.getKey());

            if (valoreInput != null && !valoreInput.trim().isEmpty()) {
                ValoreSpecificaRichiesta valore = dl.getValoreSpecificaRichiestaDAO().creaValoreRichiesta();
                valore.setRichiestaAcquisto(x);
                valore.setSpecificaCategoria(spec);
                valore.setValore(valoreInput);

                dl.getValoreSpecificaRichiestaDAO().storeValoreSpecificaRichiesta(valore);
            }
        }

        response.sendRedirect("utenteRegistrato");}
        catch (Exception e) {
        
        response.sendRedirect("richiestaAcquisto?error");
        
            
        }

    }

}
