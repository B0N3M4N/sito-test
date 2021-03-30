package com.erict.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dao.UtenteDAO;
import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.model.Utente;

public class UtenteBC {
	private Connection conn;
	
	public UtenteBC()  throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	
	public void create(Utente utente) throws DAOException {
		try {
			UtenteDAO.getFactory().create(conn, utente);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(long id) throws DAOException{
		try {
			UtenteDAO.getFactory().delete(conn, id);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
