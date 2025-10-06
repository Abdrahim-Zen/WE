/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.data.dao.impl;

import it.univaq.webmarket.data.dao.AmministratoreDAO;
import it.univaq.webmarket.data.dao.CategoriaDAO;
import it.univaq.webmarket.data.dao.ProdottoCandidatoDAO;
import it.univaq.webmarket.data.dao.ProdottoDAO;
import it.univaq.webmarket.data.dao.SpecificaCategoriaDAO;
import it.univaq.webmarket.data.dao.TecnicoDAO;
import it.univaq.webmarket.data.dao.UtenteDAO;
import it.univaq.webmarket.data.dao.UtenteRegistratoDAO;
import it.univaq.webmarket.data.model.Prodotto;
import it.univaq.webmarket.data.model.RichiestaAcquisto;
import it.univaq.webmarket.data.model.SpecificaCategoria;
import it.univaq.webmarket.data.model.Tecnico;
import it.univaq.webmarket.data.model.Utente;
import it.univaq.webmarket.data.model.UtenteRegistrato;
import it.univaq.webmarket.framework.data.DataException;
import it.univaq.webmarket.framework.data.DataLayer;
import java.sql.SQLException;
import javax.sql.DataSource;
import it.univaq.webmarket.data.dao.RichiestaAcquistoDAO;
import it.univaq.webmarket.data.dao.ValoreSpecificaRichiestaDAO;
import it.univaq.webmarket.data.model.Amministratore;
import it.univaq.webmarket.data.model.Categoria;
import it.univaq.webmarket.data.model.ProdottoCandidato;
import it.univaq.webmarket.data.model.ValoreSpecificaRichiesta;

/**
 *
 * @author abdrahimzeno
 */
public class WebMarketDataLayer extends DataLayer {

    public WebMarketDataLayer(DataSource datasource) throws SQLException {
        super(datasource);
    }

    @Override
    public void init() throws DataException {
        registerDAO(UtenteRegistrato.class, new UtenteRegistratoDAO_MySQL(this));
        registerDAO(Utente.class, new UtenteDAO_MySQL(this));
        registerDAO(Tecnico.class, new TecnicoDAO_MySQL(this));
        registerDAO(Prodotto.class, new ProdottoDAO_MySQL(this));
        registerDAO(SpecificaCategoria.class, new SpecificaCategoriaDAO_MySQL(this));
        registerDAO(RichiestaAcquisto.class, new RichiestaAcquistoDAO_MySQL(this));
        registerDAO(Categoria.class,new CategoriaDAO_MySQL(this));
        registerDAO(ValoreSpecificaRichiesta.class, new ValoreSpecificaRichiestaDAO_MySQL(this));
        registerDAO(ProdottoCandidato.class, new ProdottoCandidatoDAO_MySQL(this));
        registerDAO(Amministratore.class, new AmministratoreDAO_MySQL(this));

    }

    public UtenteDAO getUtenteDAO() {
        return (UtenteDAO) getDAO(Utente.class);
    }

    public UtenteRegistratoDAO getUtenteRegistratoDAO() {
        return (UtenteRegistratoDAO) getDAO(UtenteRegistrato.class);
    }
    
    public  TecnicoDAO getTecnicoDAO(){
        return  (TecnicoDAO) getDAO(Tecnico.class);
    }
    
    public  ProdottoDAO getProdottoDAO(){
        return (ProdottoDAO) getDAO(Prodotto.class);
    }
    public SpecificaCategoriaDAO getSpecificaCategoriaDAO(){
        return  (SpecificaCategoriaDAO) getDAO(SpecificaCategoria.class);
    }
    
    public RichiestaAcquistoDAO getRichiestaAcquistoDAO(){
        return (RichiestaAcquistoDAO) getDAO(RichiestaAcquisto.class);
    }
    
    public CategoriaDAO getCategoriaDAO(){
        return (CategoriaDAO) getDAO(Categoria.class);
    }
    
    public ValoreSpecificaRichiestaDAO getValoreSpecificaRichiestaDAO(){
        return (ValoreSpecificaRichiestaDAO) getDAO(ValoreSpecificaRichiesta.class);
    }
    
    public ProdottoCandidatoDAO getProdottoCandidatoDAO(){
        return (ProdottoCandidatoDAO) getDAO(ProdottoCandidato.class);
    }
    public AmministratoreDAO getAmministratoreDAO(){
        return (AmministratoreDAO) getDAO(Amministratore.class);
    }

}
