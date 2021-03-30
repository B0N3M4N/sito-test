package com.erict.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.erict.businesscomponent.model.OrdineArticolo;

public class OrdineArticoloDAO implements GenericDAO<OrdineArticolo>, DAOConstants{
	
	public static OrdineArticoloDAO getFactory() throws DAOException{
		return new OrdineArticoloDAO();
	}
	
	private CachedRowSet rowSet;
	
	
	
	private OrdineArticoloDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, OrdineArticolo entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_ORDINEARTICOLO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdOrdine());
			rowSet.updateLong(2, entity.getIdArticolo());
			rowSet.updateInt(3, entity.getQuantita());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void update(Connection conn, OrdineArticolo entity) throws DAOException {
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
	}

	@Override
	public OrdineArticolo getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdineArticolo[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
