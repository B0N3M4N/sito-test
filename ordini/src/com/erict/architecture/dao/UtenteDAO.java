package com.erict.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.erict.businesscomponent.model.Utente;

public class UtenteDAO implements GenericDAO<Utente>, DAOConstants{
	
	public static UtenteDAO getFactory() throws DAOException{
		return new UtenteDAO();
	}
	
	private CachedRowSet rowSet;
	
	
	
	private UtenteDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Utente entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_UTENTE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNome());
			rowSet.updateString(2, entity.getCognome());
			rowSet.updateString(3, entity.getIndirizzo());
			rowSet.updateString(4, entity.getCap());
			rowSet.updateDate(5, new java.sql.Date(entity.getNascita().getTime()));
			rowSet.updateString(6, entity.getUsername());
			rowSet.updateString(7, entity.getPassword());
			rowSet.updateString(8, entity.getEmail());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void update(Connection conn, Utente entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
