/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.UtenteRegistratoDAO;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.data.model.impl.proxy.UtenteRegistratoProxy;
import it.univaq.webmarket.framework.data.DAO;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataLayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdrahimzeno
 */
public class UtenteRegistratoDAO_MySQL extends DAO implements UtenteRegistratoDAO{
    private PreparedStatement sRegistedUserbyName;
    private PreparedStatement sUserByID;
    public UtenteRegistratoDAO_MySQL(DataLayer d){
        super(d);
    }
    
    @Override
    public void init() throws DataException{
        super.init();
        try {
              sUserByID = connection.prepareStatement(
            "SELECT u.ID, u.nome, u.cognome, u.password, u.creato_da, ur.budget_disponibile " +
            "FROM utente u JOIN utenteRegistrato ur ON u.ID = ur.ID_Utente " +
            "WHERE u.ID = ?"
        );
        
        sRegistedUserbyName = connection.prepareStatement(
            "SELECT u.ID_Utente " +
            "FROM utenteRegistrato u " +
            "JOIN utente ur ON u.ID_Utente = ur.ID " +
            "WHERE ur.nome = ? AND ur.password = ?"
        );
        } catch (SQLException ex) {
            Logger.getLogger(UtenteRegistratoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    @Override
    public UtenteRegistrato getUtenteRegistrato(String n, String p) throws DataException {
        UtenteRegistrato u= null;
        try {
            sRegistedUserbyName.setString(1, n);
            sRegistedUserbyName.setString(2, p);
            ResultSet rs = sRegistedUserbyName.executeQuery();{
            if(rs.next()){
                 return getUtente(rs.getInt("ID_Utente"));
            } 
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(UtenteRegistratoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
     
    }
    
    @Override
    public UtenteRegistrato getUtente(Integer id) throws DataException {
        UtenteRegistrato u = null;
     
        if (dataLayer.getCache().has(UtenteRegistrato.class, id)) {
            u = dataLayer.getCache().get(UtenteRegistrato.class, id);
        } else {
           
            try {
                sUserByID.setInt(1, id);
                try ( ResultSet rs = sUserByID.executeQuery()) {
                    if (rs.next()) {

                        u = createUtente(rs);
          
                        dataLayer.getCache().add(UtenteRegistrato.class, u);
                    }
                }
            } catch (SQLException ex) {
                throw new DataException("Unable to load user by ID", ex);
            }
        }
        return u;
    }
    
    public UtenteRegistrato createUtente() {
        return new UtenteRegistratoProxy(getDataLayer());
    }
    
    
    private UtenteRegistratoProxy createUtente(ResultSet rs) throws DataException {
        try {
            UtenteRegistratoProxy a = (UtenteRegistratoProxy) createUtente();
            a.setKey(rs.getInt("ID"));
            a.setCognome(rs.getString("cognome"));
            a.setNome(rs.getString("nome"));
            a.setAmministratore_key(rs.getInt("creato_da"));
            a.setBudgetDisponibile(rs.getDouble("budget_disponibile"));
            a.setPassword(rs.getString("password"));
            return a;
        } catch (SQLException ex) {
            throw new DataException("Unable to create user object form ResultSet", ex);
        }
    }
    
}
