/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.framework.data.DAO;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;
import it.univaq.webmarket.framework.data.OptimisticLockException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import it.univaq.webmarket.data.dao.RichiestaAcquistoDAO;
import it.univaq.webmarket.data.model.impl.proxy.RichiestaAcquistoProxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdrahimzeno
 */
public class RichiestaAcquistoDAO_MySQL extends DAO implements RichiestaAcquistoDAO {

    PreparedStatement iRichiesta;
    PreparedStatement uRichiesta;
    PreparedStatement sRichiestaByUtente;
    PreparedStatement sRichiestaById;
    public RichiestaAcquistoDAO_MySQL(DataLayer d) {
        super(d);
    }

    @Override
    public void init() throws DataException {
        super.init();
        try {
            iRichiesta = connection.prepareStatement(
                    "INSERT INTO richiestaAcquisto (ID_utente, ID_categoria, importo_totale, data_inserimento, note) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            uRichiesta = connection.prepareStatement(
                    "UPDATE richiestaAcquisto SET ID_utente=?, ID_categoria=?, importo_totale=?, stato=?, version=?,note=?  "
                    + "WHERE ID=? AND version=? ");
            sRichiestaByUtente= connection.prepareStatement("SELECT * FROM richiestaAcquisto WHERE ID_utente=? ");
            sRichiestaById=connection.prepareStatement("SELECT * FROM richiestaAcquisto WHERE ID=? ");
        } catch (SQLException ex) {
            Logger.getLogger(RichiestaAcquistoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void storeRichiestaAcquisto(RichiestaAcquisto richiesta) throws DataException {
    try {
        if (richiesta.getKey() != null && richiesta.getKey() > 0) {
            if (richiesta instanceof DataItemProxy && !((DataItemProxy) richiesta).isModified()) {
                return;
            }

            uRichiesta.setInt(1, richiesta.getUtenteRegistrato().getKey());
            uRichiesta.setInt(2, richiesta.getCategoria().getKey());

            if (richiesta.getImporto() != null) {
                uRichiesta.setBigDecimal(3, BigDecimal.valueOf(richiesta.getImporto()));
            } else {
                uRichiesta.setNull(3, java.sql.Types.DECIMAL);
            }

            uRichiesta.setTimestamp(4, (richiesta.getDataInserimento()));

            long current_version = richiesta.getVersion();
            long next_version = current_version + 1;

            uRichiesta.setLong(5, next_version);
            uRichiesta.setString(6, richiesta.getNote());
            uRichiesta.setInt(7, richiesta.getKey());
            uRichiesta.setLong(8, current_version);

            if (uRichiesta.executeUpdate() == 0) {
                throw new OptimisticLockException(richiesta);
            } else {
                richiesta.setVersion(next_version);
            }
        } else {
            iRichiesta.setInt(1, richiesta.getUtenteRegistrato().getKey());
            iRichiesta.setInt(2, richiesta.getCategoria().getKey());

            if (richiesta.getImporto() != null) {
                iRichiesta.setBigDecimal(3,BigDecimal.valueOf(richiesta.getImporto()));
            } else {
                iRichiesta.setNull(3, java.sql.Types.DECIMAL);
            }

           iRichiesta.setTimestamp(4, richiesta.getDataInserimento());

           
           iRichiesta.setString(5, richiesta.getNote());

            if (iRichiesta.executeUpdate() == 1) {
                try (ResultSet keys = iRichiesta.getGeneratedKeys()) {
                    if (keys.next()) {
                        int key = keys.getInt(1);
                        richiesta.setKey(key);
                        dataLayer.getCache().add(RichiestaAcquisto.class, richiesta);
                    }
                }
            }
        }

        if (richiesta instanceof DataItemProxy) {
            ((DataItemProxy) richiesta).setModified(false);
        }
    } catch (SQLException | OptimisticLockException ex) {
        throw new DataException("Unable to store richiesta acquisto", ex);
    }
}

    @Override
    public RichiestaAcquisto createRichiesta() {
       return new RichiestaAcquistoProxy(dataLayer);
    }

    @Override
    public List<RichiestaAcquisto> getRichiesteByUtenteId(int utenteid) {
        List<RichiestaAcquisto> richieste=new ArrayList<>();
        
        try {
            sRichiestaByUtente.setInt(1, utenteid);
            ResultSet rs = sRichiestaByUtente.executeQuery();
            while(rs.next()){
                richieste.add(getRichiestaById(rs.getInt("ID")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RichiestaAcquistoDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return richieste;
    }
    
    public RichiestaAcquisto getRichiestaById(int id) throws SQLException{
        RichiestaAcquisto richiesta =null;
        
       if( dataLayer.getCache().has(RichiestaAcquisto.class, id)){
           richiesta=dataLayer.getCache().get(RichiestaAcquisto.class, id);
       }else{
           sRichiestaById.setInt(1, id);
           ResultSet rs = sRichiestaById.executeQuery();
           if(rs.next()){
               richiesta=createRichiesta(rs);
               dataLayer.getCache().add(RichiestaAcquisto.class,richiesta);  
           }
       }
       return richiesta;
        
    }

    private RichiestaAcquisto createRichiesta(ResultSet rs) throws SQLException {
        RichiestaAcquistoProxy richiesta = (RichiestaAcquistoProxy) createRichiesta();
        richiesta.setKey(rs.getInt("ID"));
        richiesta.setOrdinate_key(rs.getInt("ID_utente"));
        richiesta.setCategory_key(rs.getInt("ID_categoria"));
        richiesta.setImporto(rs.getDouble("importo_totale"));
        richiesta.setNote(rs.getString("note"));
        richiesta.setStato(rs.getString("stato"));
        richiesta.setDataInserimento(rs.getTimestamp("data_inserimento"));
        return richiesta;
       
    }


}
