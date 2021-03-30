package com.erict.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.erict.architecture.dao.DAOConstants;
import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dbaccess.DBAccess;

public class OrdineIdGenerator implements IdGeneratorInterface, DAOConstants {
	private static OrdineIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private OrdineIdGenerator() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static OrdineIdGenerator getInstance() throws DAOException, ClassNotFoundException, IOException {
		if(istanza == null)
			istanza = new OrdineIdGenerator();
		return istanza;
	}
	
	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ORDINESEQ);
			rs.next();
			id = rs.getLong(1);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}

}
