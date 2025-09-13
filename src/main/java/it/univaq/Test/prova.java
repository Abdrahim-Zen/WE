/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.univaq.Test;

import it.univaq.webmarket.data.dao.impl.WebMarketDataLayer;
import it.univaq.webmarket.data.model.Utente;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataLayer;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author abdrahimzeno
 */

public class prova extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DataSource ds;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        DataLayer dl = new WebMarketDataLayer(ds);
        dl.init();
        request.setAttribute("datalayer", dl);
        giochiamo(request, response);
    } catch (Exception e) {
        e.printStackTrace(); // stampa l'eccezione nella console di Tomcat
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("Errore: " + e.getMessage());
        }
    }
}


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void giochiamo(HttpServletRequest request, HttpServletResponse response) throws DataException, IOException {
        WebMarketDataLayer dl = (WebMarketDataLayer) request.getAttribute("datalayer")  ; 
        int x =1;
        Utente utente = dl.getUtenteDAO().getUtente(x);
        response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<html>");
        out.println("<head><title>Dettagli Utente</title></head>");
        out.println("<body>");
        if (utente != null) {
            out.println("<h1>Utente trovato:</h1>");
            out.println("<p>ID: " + utente.getKey() + "</p>");
            out.println("<p>Nome: " + utente.getNome() + "</p>");
            out.println("<p>Cognome: " + utente.getCognome() + "</p>");
        } else {
            out.println("<h1>Nessun utente trovato con ID = " + x + "</h1>");
        }
        out.println("</body></html>");
    }
    }
     @Override
    
public void init(ServletConfig config) throws ServletException {
    super.init(config);
    // init data source (thread safe)
    try {
        Context ctx = new InitialContext();
        // assegna alla variabile membro della servlet
        this.ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/market");
    } catch (NamingException ex) {
        throw new ServletException(ex);
    }
}


}
