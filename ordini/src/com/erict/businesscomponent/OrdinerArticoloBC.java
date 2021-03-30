package com.erict.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dao.OrdineArticoloDAO;
import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.model.OrdineArticolo;

public class OrdinerArticoloBC {
	private Connection conn;
	
	public OrdinerArticoloBC()  throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	

	
	public void create(OrdineArticolo oa) throws DAOException {
		try {
			OrdineArticoloDAO.getFactory().create(conn, oa);
			} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

}
