package com.erict.businesscomponent;

import java.io.IOException;

import com.erict.architecture.dao.DAOException;
import com.erict.businesscomponent.model.Articolo;
import com.erict.businesscomponent.model.Ordine;
import com.erict.businesscomponent.model.OrdineArticolo;
import com.erict.businesscomponent.model.Utente;

public class ClientFacade {
	private static ClientFacade cF;
	private UtenteBC utenteBC;
	private OrdineBC ordineBC;
	private OrdinerArticoloBC oaBC;
	private ArticoloBC articoloBC;
	
	public ClientFacade() throws DAOException, ClassNotFoundException, IOException {
		utenteBC = new UtenteBC();
		articoloBC = new ArticoloBC();
		oaBC = new OrdinerArticoloBC();
		ordineBC = new OrdineBC();
	}
	
	public static ClientFacade getInstance() throws DAOException, ClassNotFoundException, IOException {
		if(cF == null)
			cF = new ClientFacade();
		return cF;
	}
	
	public void createUtente(Utente utente) throws DAOException {
		utenteBC.create(utente);
	}
	
	public void createOrUpdateArticolo(Articolo articolo) throws ClassNotFoundException, DAOException, IOException {
		articoloBC.createOrUpdate(articolo);
	}
	
	public void deleteArticolo(long id) throws DAOException {
		articoloBC.delete(id);
	}
	
	public Articolo[] getArticoli() throws DAOException {
		return articoloBC.getArticoli();
	}
	
	public Articolo[] searchArticoli(String query) throws DAOException {
		return articoloBC.searchArticolo(query);
	}
	
	public Articolo getArticoloById(long id) throws DAOException {
		return articoloBC.getById(id);
	}
	
	public void createOrdine(Ordine ordine) throws ClassNotFoundException, DAOException, IOException {
		ordineBC.create(ordine);
	}
	
	public void deleteOrdine(long id) throws DAOException {
		ordineBC.delete(id);
	}
	
	public Ordine[] getOrdini() throws DAOException {
		return ordineBC.getOrdini();
	}
	
	public void createOrdineArticolo(OrdineArticolo oa) throws DAOException {
		oaBC.create(oa);
	}
}
