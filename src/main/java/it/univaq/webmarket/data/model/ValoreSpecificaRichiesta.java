package it.univaq.webmarket.data.model;

import it.univaq.webmarket.framework.data.DataItem;

/**
 *
 * @author abdrahimzeno
 */
public interface ValoreSpecificaRichiesta extends DataItem<Integer> {

    RichiestaAcquisto getRichiestaAcquisto();

    void setRichiestaAcquisto(RichiestaAcquisto x);

    SpecificaCategoria getSpecificaCategoria();

    void setSpecificaCategoria(SpecificaCategoria x);

    String getValore(); //si intende la specfica tipo 16GB

    void setValore(String x);

}
