package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.CategoriaDAO;
import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.impl.proxy.CategoriaProxy;
import it.univaq.webmarket.framework.data.DAO;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataLayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO_MySQL extends DAO implements CategoriaDAO {

    private PreparedStatement sAllCategorie;
    private PreparedStatement sCategoraiById;

    public CategoriaDAO_MySQL(DataLayer d) {
        super(d);
    }

    @Override
    public void init() throws DataException {
        try {
            super.init();
            sAllCategorie = connection.prepareStatement("SELECT * FROM categoria");
            sCategoraiById = connection.prepareStatement("SELECT * FROM categoria WHERE ID= ?");
        } catch (SQLException ex) {
            throw new DataException("Error initializing statements in CategoriaDAO_MySQL", ex);
        }
    }

    @Override
    public List<Categoria> getAllCategorie() throws DataException {
        List<Categoria> categorie = new ArrayList<>();

        try (ResultSet rs = sAllCategorie.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = createCategoria(rs);
                categorie.add(categoria);
                dataLayer.getCache().add(Categoria.class, categoria);
            }
        } catch (SQLException ex) {
            throw new DataException("Unable to load all categorie", ex);
        }

        return categorie;
    }

    private Categoria createCategoria(ResultSet rs) throws SQLException {
        CategoriaProxy categoria = new CategoriaProxy(dataLayer);
        categoria.setKey(rs.getInt("ID"));
        categoria.setNomeCategoria(rs.getString("nome"));
        return categoria;
    }

    @Override
    public Categoria getCategoriabyID(int id) throws DataException {
        Categoria t = null;
        if (dataLayer.getCache().has(Categoria.class, id)) {
            t = dataLayer.getCache().get(Categoria.class, id);
        } else {

            try {
                sCategoraiById.setInt(1, id);
                try (ResultSet rs = sCategoraiById.executeQuery()) {
                    if (rs.next()) {

                        t = createCategoria(rs);
                        dataLayer.getCache().add(Categoria.class, t);
                    }
                }
            } catch (SQLException ex) {
                throw new DataException("Unable to load user by ID", ex);
            }
        }
        return t;
    }
}
