package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.data.model.impl.RichiestaAcquistoImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author abdrahimzeno
 */
public class RichiestaAcquistoProxy extends RichiestaAcquistoImpl implements DataItemProxy {

    protected boolean modified;
    protected DataLayer dataLayer;
    protected Integer categoria_key;
    protected Integer ordinante_key;

    public RichiestaAcquistoProxy(DataLayer d) {
        super();
        this.modified = false;
        this.dataLayer = d;
    }

    @Override
    public void setCategorai(Categoria x) {
        super.setCategorai(x);
        setModified(true);
    }

    @Override
    public void setUtenteRegistrato(UtenteRegistrato x) {
        super.setUtenteRegistrato(x);
        setModified(true);
    }

    @Override
    public void setStato(String x) {
        super.setStato(x);
        setModified(true);
    }

    @Override
    public void setDataInserimento(Timestamp x) {
        super.setDataInserimento(x);
        setModified(true);
    }

    @Override
    public void setImporto(Double x) {
        super.setImporto(x);
        setModified(true);
    }

    @Override
    public boolean isModified() {
        return this.modified;
    }

    @Override
    public void setModified(boolean dirty) {
        this.modified = dirty;
    }

    @Override
    public void setNote(String x) {
        super.setNote(x);
        setModified(true);

    }

    public void setCategory_key(int aInt) {
        this.categoria_key = aInt;
        setModified(true);
    }

    public void setOrdinate_key(int aInt) {
        this.ordinante_key = aInt;
        setModified(true);
    }

}
