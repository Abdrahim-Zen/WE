/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.AmministratoreDAO;
import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.impl.proxy.AmministratoreProxy;
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
 * @author abrah
 */
public class AmministratoreDAO_MySQL extends DAO implements AmministratoreDAO{
    private PreparedStatement sAmministratoreByEmail;
    private PreparedStatement sAmministratoreById;
   
    public AmministratoreDAO_MySQL(DataLayer d) {
        super(d);
    }
    
    @Override
    public void init() throws DataException{
        super.init();
        try{
            sAmministratoreByEmail=connection.prepareStatement("SELECT a.* FROM amministratore a WHERE a.email=?");
            
            sAmministratoreById=connection.prepareStatement("SELECT a.* FROM amministratore a WHERE a.ID=?");
        }
        catch (SQLException ex) {
            Logger.getLogger(AmministratoreDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Amministratore getAmmistratorebyEmail(String x)throws DataException {
        Amministratore a=null;
        try{
            sAmministratoreByEmail.setString(1, x);
            ResultSet rs=sAmministratoreByEmail.executeQuery();
            if(rs.next()){
                return getAmministratorebyID(rs.getInt("ID"));
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(AmministratoreDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public Amministratore getAmministratorebyID(Integer x) throws DataException{
        Amministratore a=null;
        
        if(dataLayer.getCache().has(Amministratore.class, x)){
            a=dataLayer.getCache().get(Amministratore.class, x);
        }else {
            try{
                sAmministratoreById.setInt(1,x);
                ResultSet rs = sAmministratoreById.executeQuery();
                if(rs.next()){
                    a=createAmministratore(rs);
                }
            
            }
            catch (SQLException ex) {
                throw new DataException("Unable to load user by ID", ex);
            }
        }
         return a;
        
    }

    private AmministratoreProxy createAmministratore(ResultSet rs) throws DataException{
        try{
            AmministratoreProxy a =(AmministratoreProxy) createAmministratore();
            a.setNome(rs.getString("nome"));
            a.setKey(rs.getInt("ID"));
            a.setCognome(rs.getString("cognome"));
            a.setPassword(rs.getString("password"));
            a.setEmail(rs.getString("email"));
            return a;
        }catch (SQLException ex) {
            throw new DataException("Unable to create user object form ResultSet", ex);
        }
        
    }
    
    private Amministratore  createAmministratore(){
        return new AmministratoreProxy(getDataLayer());
    }
    
}
