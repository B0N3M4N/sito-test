package test.com.erict.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dao.OrdineDAO;
import com.erict.architecture.dao.UtenteDAO;
import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.model.Ordine;
import com.erict.businesscomponent.model.Utente;

class OrdineDAOTest {
	private static Connection conn;
	private static Utente utente;
	private static Ordine ordine;

	@BeforeAll
	static void setUp() throws Exception {
			conn = DBAccess.getConnection();
			utente = new Utente();
			utente.setNome("Massimo");
			utente.setCognome("Rossi");
			utente.setIndirizzo("Via Brollo, 5");
			utente.setCap("91256");
			utente.setNascita(new GregorianCalendar(2000,10,1).getTime());
			utente.setUsername("max");
			utente.setPassword("brobb");
			utente.setEmail("max@bruh.com");
			
			ordine = new Ordine();
			ordine.setIdOrdine(1);
			ordine.setTotale(1000);
			ordine.setData(new Date());
			ordine.setUsername("max");
	}
	
	@Test
	void testCreate() {
		try {
			UtenteDAO.getFactory().create(conn, utente);
			OrdineDAO.getFactory().create(conn, ordine);
			System.out.println("Ordine creato");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Creazione ordine fallita");
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Ordine[] ordini = OrdineDAO.getFactory().getAll(conn);
			assertNotNull(ordini);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero dati fallito");
		}
	}
	
	@AfterAll
	static void tearDown() throws Exception {
		try {
			ordine = null;
			utente = null;
			Statement stmt = conn.createStatement();
			OrdineDAO.getFactory().delete(conn, 1);
			stmt.executeUpdate("Delete from utente");
			conn.commit();
			System.out.println("Pulito il DB");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Pulizia DB fallita");
		}
	}

}
