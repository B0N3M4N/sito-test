package test.com.erict.architecture.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dao.UtenteDAO;
import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.model.Utente;


class UtenteDAOTest {
	private Utente utente;
	private Connection conn;

	@BeforeEach
	void setUp() throws Exception {
		utente = new Utente();
		utente.setNome("Massimo");
		utente.setCognome("Rossi");
		utente.setIndirizzo("Via Brollo, 5");
		utente.setCap("91256");
		utente.setNascita(new GregorianCalendar(2000,10,1).getTime());
		utente.setUsername("max");
		utente.setPassword("brobb");
		utente.setEmail("max@bruh.com");
	}

	@AfterEach
	void tearDown() throws Exception {
		utente = null;
		conn = DBAccess.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from utente where username='max'");
		conn.commit();
		DBAccess.closeConnection();
	}

	@Test
	void testCreate() {
		try {
			UtenteDAO.getFactory().create(DBAccess.getConnection(), utente);
			System.out.println("Creato utente");
		} catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			System.out.println("Errore nella creazione: ");
		}
	}

}
