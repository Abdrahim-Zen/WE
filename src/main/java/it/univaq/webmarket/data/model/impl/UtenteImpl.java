
package it.univaq.webmarket.data.model.impl;

import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.Utente;
import it.univaq.webmarket.framework.data.DataItemImpl;

/**
 *
 * @author abdrahimzeno
 */
public class UtenteImpl extends DataItemImpl<Integer> implements Utente{
    private String nome;
    private String cognome;
    private Amministratore amministratore;
    private String password;
    private String email;
    
    public UtenteImpl(){
        super();
        nome=null;
        cognome=null;
        amministratore=null;
    }
    
    
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getCognome() {
        return this.cognome; 
    }

    @Override
    public void setNome(String name) {
        this.nome=name; 
    }

    @Override
    public void setCognome(String surname) {
        this.cognome=surname; 
    }

    @Override
    public Amministratore getAmministratore() {
        return amministratore; 
    }

    @Override
    public void setAmministratore(Amministratore x) {
        this.amministratore=x; 
    }

    @Override
    public void setPassword(String x) {
        this.password=x; 
    }

    @Override
    public String getPassword() {
        return password; 
    }

    @Override
    public String getEmail() {
       return email;
    }

    @Override
    public void setEmail(String x) {
       this.email=x;  
    }
    

  
    
    
}
