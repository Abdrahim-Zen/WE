/*
 * LoginController.java
 *
 *
 */
package it.univaq.webmarket.controller;

import it.univaq.webmarket.application.ApplicationBaseController;
import it.univaq.webmarket.data.dao.impl.WebMarketDataLayer;
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

    private void action_login(HttpServletRequest request, HttpServletResponse response) throws IOException, DataException {

        WebMarketDataLayer dl = (WebMarketDataLayer) request.getAttribute("datalayer");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UtenteRegistrato utente = dl.getUtenteRegistratoDAO().getUtenteRegistrato(username, password);
        HttpSession session = SecurityHelpers.checkSession(request);
        Tecnico tecnico = null;

        if (utente == null) {
            tecnico = dl.getTecnicoDAO().getTecnicoByName(username, password);
            if (tecnico == null) {
                response.sendRedirect("login?error=2");
                return;
            }

            SecurityHelpers.createSession(request, tecnico.getNome(), tecnico.getKey());
            response.sendRedirect("tecnico");
        } else {

            SecurityHelpers.createSession(request, username, utente.getKey());
            response.sendRedirect("utenteRegistrato");
        }

    }
}
