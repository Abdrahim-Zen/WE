/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.TecnicoIncaricato;
import it.univaq.webmarket.data.model.impl.ProdottoCandidatoImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;
import java.sql.Timestamp;

/**
 *
 * @author abdrahimzeno
 */
public class ProdottoCandidatoProxy extends ProdottoCandidatoImpl implements DataItemProxy {

    protected boolean modified;
    protected DataLayer dataLayer;
    protected int tecnico_key;
    protected int richiesta_key;
    public ProdottoCandidatoProxy(DataLayer d) {
        super();
        this.modified = false;
        this.dataLayer = d;
    }

    @Override
    public void setDescrizione(String x) {
        super.setDescrizione(x);
        setModified(true);
    }

    @Override
    public void setPrezzo(Double x) {
        super.setPrezzo(x);
        setModified(true);
    }
    
    @Override
    public void setDataProposta(Timestamp  x){
        super.setDataProposta(x);
        setModified(true);
    }
    
    public void setTecnicoKey(int x){
        this.tecnico_key=x;
    }
    
    public void setRichiesta_key(int x){
        this.richiesta_key=x;
    }
    
    @Override
    public void setNome(String x){
        super.setNome(x);
        setModified(true);
    }
    

    @Override
    public boolean isModified() {
        return modified;
    }

    @Override
    public void setModified(boolean dirty) {
        this.modified = dirty;
    }

}
