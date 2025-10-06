/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.ValoreSpecificaRichiestaDAO;
import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.ValoreSpecificaRichiesta;
import it.univaq.webmarket.data.model.impl.proxy.ValoreSpecificaRichiestaProxy;
import it.univaq.webmarket.framework.data.DAO;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;
import it.univaq.webmarket.framework.data.OptimisticLockException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdrahimzeno
 */
public class ValoreSpecificaRichiestaDAO_MySQL extends DAO implements ValoreSpecificaRichiestaDAO {

    private PreparedStatement iValoreRichiesta;
    private PreparedStatement uValoreRichiesta;

    public ValoreSpecificaRichiestaDAO_MySQL(DataLayer d) {
        super(d);
    }
    @Override
    public void init() throws DataException{
        super.init();
        try {
            iValoreRichiesta=connection.prepareStatement("INSERT INTO specifiche_richiesta (ID_richiesta, ID_specifica_categoria, valore) "
                    + "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            uValoreRichiesta=connection.prepareStatement("UPDATE specifiche_richiesta SET ID_richiesta=?, ID_specifica_categoria=?, valore=?, version=? "
                    +"WHERE ID=? AND version=? ");
        } catch (SQLException ex) {
            Logger.getLogger(ValoreSpecificaRichiestaDAO_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void storeValoreSpecificaRichiesta(ValoreSpecificaRichiesta richiesta) throws DataException {
    try {
       
        if (richiesta.getKey() != null && richiesta.getKey() > 0) {
            if (richiesta instanceof DataItemProxy && !((DataItemProxy) richiesta).isModified()) {
                return;
            }

            uValoreRichiesta.setInt(1, richiesta.getRichiestaAcquisto().getKey());
            uValoreRichiesta.setInt(2, richiesta.getSpecificaCategoria().getKey());

            uValoreRichiesta.setString(3, richiesta.getValore());

            long current_version = richiesta.getVersion();
            long next_version = current_version + 1;

            uValoreRichiesta.setLong(4, next_version);

            uValoreRichiesta.setInt(5, richiesta.getKey());
            uValoreRichiesta.setLong(6, current_version);

            if (uValoreRichiesta.executeUpdate() == 0) {
                throw new OptimisticLockException(richiesta);
            } else {
                richiesta.setVersion(next_version);
            }
        } else {
            iValoreRichiesta.setInt(1, richiesta.getRichiestaAcquisto().getKey());
            iValoreRichiesta.setInt(2, richiesta.getSpecificaCategoria().getKey());

           iValoreRichiesta.setString(3, richiesta.getValore());
           
       

            if (iValoreRichiesta.executeUpdate() == 1) {
                try (ResultSet keys = iValoreRichiesta.getGeneratedKeys()) {
                    if (keys.next()) {
                        int key = keys.getInt(1);
                        richiesta.setKey(key);
                        dataLayer.getCache().add(ValoreSpecificaRichiesta.class, richiesta);
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
    public ValoreSpecificaRichiesta creaValoreRichiesta() {
        return new ValoreSpecificaRichiestaProxy(dataLayer); 
    }

}
