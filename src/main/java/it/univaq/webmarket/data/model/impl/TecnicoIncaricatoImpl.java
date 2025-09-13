
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.Tecnico;
import it.univaq.webmarket.data.model.TecnicoIncaricato;
import it.univaq.webmarket.framework.data.DataItemImpl;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public class TecnicoIncaricatoImpl extends DataItemImpl<Integer> implements TecnicoIncaricato{
    private Tecnico tecnico;
    private RichiestaAcquisto richiestaAcquisto;
    private LocalDateTime dataInserimento;
    
    public TecnicoIncaricatoImpl(){
        super();
        tecnico=null;
        richiestaAcquisto=null;
        dataInserimento=null;
    }
    
    @Override
    public Tecnico getTecnico() {
        return tecnico; 
    }

    @Override
    public void setTecnico(Tecnico x) {
        this.tecnico=x; 
    }

    @Override
    public RichiestaAcquisto getRichiestaAcquisto() {
        return  richiestaAcquisto; 
    }

    @Override
    public void setRichiestaAcquisto(RichiestaAcquisto x) {
       this.richiestaAcquisto=x; 
    }

    @Override
    public LocalDateTime getDataInserimento() {
        return dataInserimento; 
    }

    @Override
    public void setDataInserimento(LocalDateTime x) {
        this.dataInserimento=x;
    }
 
}
