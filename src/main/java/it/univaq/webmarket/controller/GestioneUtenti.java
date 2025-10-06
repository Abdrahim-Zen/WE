
package it.univaq.webmarket.controller;

import it.univaq.webmarket.application.ApplicationBaseController;
import it.univaq.webmarket.data.dao.impl.WebMarketDataLayer;
import it.univaq.webmarket.data.model.Utente;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.security.SecurityHelpers;
import it.univaq.webmarket.framework.view.TemplateManagerException;
import it.univaq.webmarket.framework.view.TemplateResult;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abrah
 */

public class GestioneUtenti extends ApplicationBaseController {

     @Override
    public void init(ServletConfig config) throws jakarta.servlet.ServletException {
        super.init(config);
    }
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DataException, TemplateManagerException {
         HttpSession session = SecurityHelpers.checkSession(request);
        if(session==null){
            response.sendRedirect("login?error=3");
            return;
        }
        WebMarketDataLayer dl = (WebMarketDataLayer) request.getAttribute("datalayer");
        Integer idAmministratore = (Integer) session.getAttribute("userid");
        
        List<Utente> utenti =dl.getUtenteDAO().getUtentiCreatiDa(idAmministratore);
        Map<String, Object> datamodel = new HashMap<>();
        datamodel.put("utenti", utenti);
        TemplateResult result = new TemplateResult(getServletContext());
        result.activate("gestioneUtenti.ftl.html", datamodel, request, response);
        
    }



}
