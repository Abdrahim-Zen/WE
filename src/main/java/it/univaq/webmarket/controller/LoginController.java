/*
 * LoginController.java
 *
 *
 */
package it.univaq.webmarket.controller;

import it.univaq.webmarket.application.ApplicationBaseController;
import it.univaq.webmarket.data.dao.impl.WebMarketDataLayer;
import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.Tecnico;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.security.SecurityHelpers;
import it.univaq.webmarket.framework.view.TemplateManagerException;
import it.univaq.webmarket.framework.view.TemplateResult;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 *
 *
 * @version
 */
public class LoginController extends ApplicationBaseController {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getParameter("login") != null) {
            action_login(request, response);
        } else {
            action_default(request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response) throws TemplateManagerException, IOException {
        TemplateResult result = new TemplateResult(getServletContext());
        request.setAttribute("error", request.getParameter("error"));
        result.activate("login.ftl.html", request, response);
    }

    private void action_login(HttpServletRequest request, HttpServletResponse response) throws IOException, DataException, NoSuchAlgorithmException, InvalidKeySpecException {

        WebMarketDataLayer dl = (WebMarketDataLayer) request.getAttribute("datalayer");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UtenteRegistrato utente = dl.getUtenteRegistratoDAO().getUtenteRegistrato(email);

        if (utente != null && SecurityHelpers.checkPasswordHashPBKDF2(password, utente.getPassword())) {
            SecurityHelpers.createSession(request, utente.getNome(), utente.getKey());
            response.sendRedirect("utenteRegistrato");
            return;
        }
        Tecnico tecnico = dl.getTecnicoDAO().getTecnicoByName(email, email);
        if(tecnico !=null && SecurityHelpers.checkPasswordHashPBKDF2(password, tecnico.getPassword())){
            SecurityHelpers.createSession(request, tecnico.getNome(), tecnico.getKey());
            response.sendRedirect("tecnico");
            return;
        }
        
        Amministratore amministratore = dl.getAmministratoreDAO().getAmmistratorebyEmail(email);
        if(amministratore !=null && SecurityHelpers.checkPasswordHashPBKDF2(password, amministratore.getPassword())){
        SecurityHelpers.createSession(request, amministratore.getNome(),amministratore.getKey());
        response.sendRedirect("amministratore");
        return;
        }
            
        else{
             response.sendRedirect("login?error=2");
        }
        /*         
        if (utente == null||!SecurityHelpers.checkPasswordHashPBKDF2(password, utente.getPassword())) {
            Tecnico tecnico = dl.getTecnicoDAO().getTecnicoByName(email, password);
            if (tecnico == null||!SecurityHelpers.checkPasswordHashPBKDF2(password, tecnico.getPassword())) {
                
                
                response.sendRedirect("login?error=2");
                return;
            }

            SecurityHelpers.createSession(request, tecnico.getNome(), tecnico.getKey());
            response.sendRedirect("tecnico");
        } else {

            SecurityHelpers.createSession(request, utente.getNome(), utente.getKey());
            response.sendRedirect("utenteRegistrato");
        }*/

    }
}
