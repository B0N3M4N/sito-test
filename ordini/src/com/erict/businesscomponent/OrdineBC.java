package com.erict.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dao.OrdineDAO;
import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.idgenerator.OrdineIdGenerator;
import com.erict.businesscomponent.model.Ordine;

public class OrdineBC {
	private Connection conn;
	private OrdineIdGenerator idGen;
	
	public OrdineBC()  throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
		idGen = OrdineIdGenerator.getInstance();
	}
	
	public void create(Ordine ordine) throws ClassNotFoundException, IOException, DAOException {
		try {
			ordine.setIdOrdine(idGen.getNextId());
			ordine.setData(new Date());
			OrdineDAO.getFactory().create(conn, ordine);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Ordine[] getOrdini() throws DAOException {
		Ordine[] ordini = null;
		try {
			ordini = OrdineDAO.getFactory().getAll(conn);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return ordini;
	}
	
	public void delete(long id) throws DAOException{
		try {
			OrdineDAO.getFactory().delete(conn, id);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
