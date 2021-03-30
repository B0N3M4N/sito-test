package com.erict.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.erict.architecture.dao.DAOConstants;
import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dbaccess.DBAccess;

public class ArticoloIdGenerator implements IdGeneratorInterface, DAOConstants {
	private static ArticoloIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private ArticoloIdGenerator() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static ArticoloIdGenerator getInstance() throws DAOException, ClassNotFoundException, IOException {
		if(istanza == null)
			istanza = new ArticoloIdGenerator();
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
