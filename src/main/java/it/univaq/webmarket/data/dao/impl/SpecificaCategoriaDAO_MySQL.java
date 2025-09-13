package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.SpecificaCategoriaDAO;
import it.univaq.webmarket.data.model.SpecificaCategoria;
import it.univaq.webmarket.data.model.impl.proxy.SpecificaCategoriaProxy;
import it.univaq.webmarket.framework.data.DAO;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpecificaCategoriaDAO_MySQL extends DAO implements SpecificaCategoriaDAO {

    private PreparedStatement sSpecificheByCategoriaId;
    private PreparedStatement sSpecificaById;

    public SpecificaCategoriaDAO_MySQL(DataLayer d) {
        super(d);
    }

    @Override
    public void init() throws DataException {
        super.init();
        try {
            // Query per ottenere le specifiche per una categoria
            sSpecificheByCategoriaId = connection.prepareStatement(
                "SELECT * FROM specifica_categoria WHERE ID_categoria = ?"
            );

            // Query per ottenere una specifica per id
            sSpecificaById = connection.prepareStatement(
                "SELECT * FROM specifica_categoria WHERE ID = ?"
            );
        } catch (SQLException ex) {
            Logger.getLogger(SpecificaCategoriaDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DataException("Errore inizializzazione SpecificaCategoriaDAO", ex);
        }
    }

    @Override
    public List<SpecificaCategoria> getListSpecificaCategoria(int idCategoria) throws DataException {
        List<SpecificaCategoria> specifiche = new ArrayList<>();
        try {
            sSpecificheByCategoriaId.setInt(1, idCategoria);
            try (ResultSet rs = sSpecificheByCategoriaId.executeQuery()) {
                while (rs.next()) {
                    // usa l'id della specifica per caricare tramite getSpecificaCategoria()
                    specifiche.add(getSpecificaCategoria(rs.getInt("ID")));
                }
            }
        } catch (SQLException ex) {
            throw new DataException("Errore nel caricamento delle specifiche della categoria", ex);
        }
        return specifiche;
    }

    @Override
    public SpecificaCategoria getSpecificaCategoria(int id) throws DataException {
        SpecificaCategoria spec = null;

        if (dataLayer.getCache().has(SpecificaCategoria.class, id)) {
            spec = dataLayer.getCache().get(SpecificaCategoria.class, id);
        } else {
            try {
                sSpecificaById.setInt(1, id);
                try (ResultSet rs = sSpecificaById.executeQuery()) {
                    if (rs.next()) {
                        spec = createSpecificaCategoria(rs);
                        dataLayer.getCache().add(SpecificaCategoria.class, spec);
                    }
                }
            } catch (SQLException ex) {
                throw new DataException("Errore nel caricamento della specifica categoria", ex);
            }
        }
        return spec;
    }

    public SpecificaCategoria createSpecificaCategoria() {
        return new SpecificaCategoriaProxy(getDataLayer());
    }

    private SpecificaCategoria createSpecificaCategoria(ResultSet rs) throws SQLException, DataException {
        SpecificaCategoriaProxy spec = (SpecificaCategoriaProxy) createSpecificaCategoria();
        spec.setKey(rs.getInt("ID"));
        spec.setCategoriaKey(rs.getInt("ID_categoria"));
        spec.setNomeSpecifica(rs.getString("nome_specifica"));
        return spec;
    }
}
