package com.erict.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.erict.architecture.dao.DAOConstants;
import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dbaccess.DBAccess;
	public class LoginUtility implements DAOConstants {
			private Connection conn;
			public LoginUtility() throws DAOException, ClassNotFoundException, IOException {
					conn = DBAccess.getConnection();
				}
			public String getUserPass(String username) throws DAOException {
				try {
					PreparedStatement ps = conn.prepareStatement(SELECT_USERPASS);
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						return rs.getString(1);
					} else
					return null;
				} catch (SQLException sql) {
					// TODO: handle exception
					throw new DAOException(sql);
				}
			}
			public String getAdminPass(String username) throws DAOException {
				try {
					PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						return rs.getString(1);
					} else
					return null;
				} catch (SQLException sql) {
					// TODO: handle exception
					throw new DAOException(sql);
				}
			}
}