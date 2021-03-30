package com.erict.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erict.architecture.dao.ArticoloDAO;
import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.idgenerator.OrdineIdGenerator;
import com.erict.businesscomponent.model.Articolo;

public class ArticoloBC {
	private Connection conn;
	private OrdineIdGenerator idGen;
	
	public ArticoloBC()  throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	
	public Articolo[] searchArticolo(String query) throws DAOException {
		ArrayList<Articolo> lista = new ArrayList<Articolo>(50);
		String[] criterioRicerca = query.toLowerCase().split(" ");
		
		for(Articolo a : getArticoli())
			for(String s : criterioRicerca)
				if(a.getMarca().toLowerCase().contains(s) ||
				a.getModello().toLowerCase().contains(s))
					lista.add(a);
		
		Articolo[] articoli = new Articolo[lista.size()];
		for(int i = 0; i<lista.size(); i++) {
			articoli[i] = lista.get(i);
		}
		
		return articoli;
	}
	
	public void createOrUpdate(Articolo articolo) throws ClassNotFoundException, IOException, DAOException {
		try {
			if(articolo.getIdArticolo() > 0) {
				ArticoloDAO.getFactory().update(conn, articolo);
			} else {
				idGen = OrdineIdGenerator.getInstance();
				articolo.setIdArticolo(idGen.getNextId());
				ArticoloDAO.getFactory().create(conn, articolo);
			}
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Articolo[] getArticoli() throws DAOException {
		Articolo[] articoli = null;
		try {
			articoli = ArticoloDAO.getFactory().getAll(conn);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return articoli;
	}
	
	public void delete(long id) throws DAOException{
		try {
			ArticoloDAO.getFactory().delete(conn, id);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Articolo getById(long id) throws DAOException {
		try {
			return ArticoloDAO.getFactory().getById(conn, id);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
