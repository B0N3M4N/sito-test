package test.com.erict.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void testGetConnection() {
		try {
			DBAccess.getConnection();
		} catch(DAOException | IOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			fail("Errore nel tentativo di connessione");
		} finally {
			try {
				DBAccess.closeConnection();
			} catch(DAOException exc) {
				exc.printStackTrace();
				fail("Errore nel tentativo di chiusura della conessione");
			}
		}
	}

}
