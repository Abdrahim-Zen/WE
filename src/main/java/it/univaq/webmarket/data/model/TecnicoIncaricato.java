
package it.univaq.webmarket.data.model;

import it.univaq.webmarket.framework.data.DataItem;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public interface TecnicoIncaricato extends DataItem<Integer>  {
    Tecnico getTecnico();
    void setTecnico(Tecnico x);
    
    RichiestaAcquisto getRichiestaAcquisto();
    void setRichiestaAcquisto(RichiestaAcquisto x);
    
    LocalDateTime getDataInserimento();
    void setDataInserimento(LocalDateTime x);
    
    
    
}
