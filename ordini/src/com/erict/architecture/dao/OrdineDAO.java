package com.erict.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.erict.businesscomponent.model.Ordine;

public class OrdineDAO implements GenericDAO<Ordine>, DAOConstants{
	
	public static OrdineDAO getFactory() throws DAOException{
		return new OrdineDAO();
	}
	
	private CachedRowSet rowSet;
	
	
	
	private OrdineDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void create(Connection conn, Ordine entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_ORDINE);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getIdOrdine());
			rowSet.updateDouble(2, entity.getTotale());
			rowSet.updateDate(3, new java.sql.Date(entity.getData().getTime()));
			rowSet.updateString(4, entity.getUsername());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void update(Connection conn, Ordine entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_ORDINE);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public Ordine getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordine[] getAll(Connection conn) throws DAOException {
		Ordine[] ordini = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_ORDINE);
			rs.last();
			ordini = new Ordine[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Ordine o = new Ordine();
				o.setIdOrdine(rs.getLong(1));
				o.setTotale(rs.getDouble(2));
				o.setData(new java.util.Date(rs.getDate(3).getTime()));
				o.setUsername(rs.getString(4));
				ordini[i] = o;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return ordini;
	}
	
	

}
