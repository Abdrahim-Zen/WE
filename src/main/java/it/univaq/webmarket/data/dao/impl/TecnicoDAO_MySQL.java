/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.TecnicoDAO;
import it.univaq.webmarket.data.model.Tecnico;
import it.univaq.webmarket.data.model.impl.proxy.TecnicoProxy;
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
public class TecnicoDAO_MySQL extends DAO implements TecnicoDAO {

    private PreparedStatement sTecnicoByName;
    private PreparedStatement sTecnicoByID;

    public TecnicoDAO_MySQL(DataLayer d) {
        super(d);
    }

    @Override
    public void init() throws DataException {
        super.init();

        try {
            sTecnicoByName = connection.prepareStatement("SELECT t.*, u.* "
                    + "FROM tecnico t "
                    + "JOIN utente u ON t.ID = u.ID "
                    + "WHERE u.email = ? ");
            sTecnicoByID = connection.prepareStatement("SELECT * "
                    + "FROM utente u JOIN tecnico t ON u.ID = t.ID "
                    + "WHERE u.ID = ?");
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Tecnico getTecnicoByName(String n) throws DataException {
        Tecnico t = null;

        try {
            sTecnicoByName.setString(1, n);
            ResultSet rs = sTecnicoByName.executeQuery();
            if (rs.next()) {
                t = getTecnicoByID(rs.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Tecnico getTecnicoByID(int id) throws DataException {
        Tecnico t = null;
        if (dataLayer.getCache().has(Tecnico.class, id)) {
            t = dataLayer.getCache().get(Tecnico.class, id);
        } else {

            try {
                sTecnicoByID.setInt(1, id);
                try ( ResultSet rs = sTecnicoByID.executeQuery()) {
                    if (rs.next()) {

                        t = createTecnico(rs);
                        dataLayer.getCache().add(Tecnico.class, t);
                    }
                }
            } catch (SQLException ex) {
                throw new DataException("Unable to load user by ID", ex);
            }
        }
        return t;
    }

    public Tecnico createUtente() {
        return new TecnicoProxy(getDataLayer());
    }

    private Tecnico createTecnico(ResultSet rs) throws DataException {
        try {
            TecnicoProxy a = (TecnicoProxy) createUtente();
            a.setNome(rs.getString("nome"));
            a.setKey(rs.getInt("ID"));
            a.setDataAssunzione(rs.getDate("data_assunzione").toLocalDate());
            a.setPassword(rs.getString("password"));
            a.setStato(rs.getString("stato"));
            return a;
        } catch (SQLException ex) {
            throw new DataException("Unable to create user object form ResultSet", ex);
        }
    }

}
