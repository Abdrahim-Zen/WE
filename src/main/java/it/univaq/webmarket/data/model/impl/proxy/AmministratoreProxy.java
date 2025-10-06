

package it.univaq.webmarket.data.model.impl.proxy;

import it.univaq.webmarket.data.model.impl.AmministratoreImpl;
import it.univaq.webmarket.framework.data.DataItemProxy;
import it.univaq.webmarket.framework.data.DataLayer;

/**
 *
 * @author abrah
 */
public class AmministratoreProxy extends AmministratoreImpl implements  DataItemProxy{
    protected boolean modified;
    protected DataLayer dataLayer;
    
    public AmministratoreProxy(DataLayer d){
        super();
        this.dataLayer=d;
        this.modified=false;
    }
    
    @Override
    public void setNome(String x){
        super.setNome(x);
        setModified(true);
    }
    
    @Override
    public void setPassword(String x){
        super.setPassword(x);
        setModified(true);
    }
    
    @Override
    public void setCognome(String x){
        super.setCognome(x);
        setModified(true);
    }
    
    @Override
    public void setEmail(String x){
        super.setEmail(x);
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
