package test.com.erict.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.erict.architecture.dao.ArticoloDAO;
import com.erict.architecture.dao.DAOException;
import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.model.Articolo;

class ArticoloDAOTest {
	private static Articolo articolo;
	private static Connection conn;

	@BeforeAll
	static void setUp() throws Exception {
		conn = DBAccess.getConnection();
		articolo = new Articolo();
		articolo.setIdArticolo(10);
		articolo.setMarca("HP");
		articolo.setModello("Envy");
		articolo.setPrezzo(1200);
	}
	
	@Test
	void testCreate() {
		try {
			ArticoloDAO.getFactory().create(conn, articolo);
			System.out.println("Articolo creato");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Creazione articolo fallita");
		}
	}
	
	@Test
	void testUpdate() {
		try {
			articolo = new Articolo();
			articolo.setIdArticolo(10);
			articolo.setMarca("HP");
			articolo.setModello("Envy 2");
			articolo.setPrezzo(1400);
			ArticoloDAO.getFactory().update(conn, articolo);
			System.out.println("Articolo modificato");
			Articolo articolo = ArticoloDAO.getFactory().getById(conn, 10);
			System.out.println("Prezzo modificato"+articolo.getPrezzo());
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Creazione articolo fallita");
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Articolo[] articoli = ArticoloDAO.getFactory().getAll(conn);
			assertNotNull(articoli);
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero dati fallito");
		}
	}
	
	@AfterAll
	static void tearDown() throws Exception {
		try {
			articolo = null;
			ArticoloDAO.getFactory().delete(conn, 10);
			conn.commit();
			System.out.println("Pulito il DB");
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Pulizia DB fallita");
		}
	}

}
