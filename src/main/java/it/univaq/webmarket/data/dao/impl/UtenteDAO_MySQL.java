/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.UtenteDAO;
import it.univaq.webmarket.data.model.Utente;
import it.univaq.webmarket.data.model.impl.proxy.UtenteProxy;
import it.univaq.webmarket.framework.data.DAO;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataLayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public class UtenteDAO_MySQL extends DAO implements UtenteDAO{
    private PreparedStatement sUserByID;
  
    
    
    public UtenteDAO_MySQL(DataLayer d) {
        super(d);
    }
    
    @Override
    public void init() throws DataException {
        try {
            super.init();
            sUserByID = connection.prepareStatement("SELECT * FROM utente WHERE ID=?"); // precompilo le istruzioni SQL
        
        } catch (SQLException ex) {
            throw new DataException("Error initializing market data layer", ex);
        }
    }
    
    @Override
    public void destroy() throws DataException {

        try {
            sUserByID.close();

        } catch (SQLException ex) {
           
        }
        super.destroy();
    }
    
    public Utente createUtente() {
        return new UtenteProxy(getDataLayer());
    }
    
    private UtenteProxy createUtente(ResultSet rs) throws DataException {
        try {
            UtenteProxy a = (UtenteProxy) createUtente();
            a.setKey(rs.getInt("ID"));
            a.setCognome(rs.getString("cognome"));
            a.setNome(rs.getString("nome"));
            a.setAmministratore_key(rs.getInt("creato_da"));
            return a;
        } catch (SQLException ex) {
            throw new DataException("Unable to create user object form ResultSet", ex);
        }
    }
    

    @Override
    public Utente getUtente(int id) throws DataException {
        Utente u = null;
        //prima vediamo se l'oggetto è già stato caricato
        //first look for this object in the cache
        if (dataLayer.getCache().has(Utente.class, id)) {
            u = dataLayer.getCache().get(Utente.class, id);
        } else {
            //altrimenti lo carichiamo dal database
            //otherwise load it from database
            try {
                sUserByID.setInt(1, id);
                try ( ResultSet rs = sUserByID.executeQuery()) {
                    if (rs.next()) {
                        //notare come utilizziamo il costrutture
                        //"helper" della classe AuthorImpl
                        //per creare rapidamente un'istanza a
                        //partire dal record corrente
                        //note how we use here the helper constructor
                        //of the AuthorImpl class to quickly
                        //create an instance from the current record

                        u = createUtente(rs);
                        //e lo mettiamo anche nella cache
                        //and put it also in the cache
                        dataLayer.getCache().add(Utente.class, u);
                    }
                }
            } catch (SQLException ex) {
                throw new DataException("Unable to load user by ID", ex);
            }
        }
        return u;
    }

    @Override
    public List<Utente> getUtentiCreatiDa(int idAmministratore) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
