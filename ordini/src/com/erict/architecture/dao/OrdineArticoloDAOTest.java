package com.erict.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.erict.architecture.dbaccess.DBAccess;
import com.erict.businesscomponent.model.Articolo;
import com.erict.businesscomponent.model.Ordine;
import com.erict.businesscomponent.model.OrdineArticolo;
import com.erict.businesscomponent.model.Utente;

class OrdineArticoloDAOTest {
	private static OrdineArticolo oa;
	private static Connection conn;
	private static Utente utente;
	private static Ordine ordine;
	private static Articolo articolo;

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
		utente = new Utente();
		utente.setNome("Max");
		utente.setCognome("Rossi");
		utente.setIndirizzo("Via Bollo, 5");
		utente.setCap("92500");
		utente.setNascita(new GregorianCalendar(2000, 10, 1).getTime());
    	utente.setUsername("max");
    	utente.setPassword("pass1");
    	utente.setEmail("max@bruhmail.com");

    	ordine = new Ordine();
    	ordine.setIdOrdine(1);
    	ordine.setTotale(1000);
    	ordine.setData(new Date());
    	ordine.setUsername("max");
    
    	articolo = new Articolo();
    	articolo.setIdArticolo(10);
    	articolo.setMarca("HP");
    	articolo.setModello("Envy");
    	articolo.setPrezzo(1200);
    
    	oa = new OrdineArticolo();
    	oa.setIdOrdine(1);
    	oa.setIdArticolo(10);
    	oa.setQuantita(5);
	}

  @Test
  	void testCreate() {
	  try {
		  UtenteDAO.getFactory().create(conn, utente);
		  OrdineDAO.getFactory().create(conn, ordine);
		  ArticoloDAO.getFactory().create(conn, articolo);
		  OrdineArticoloDAO.getFactory().create(conn, oa);
		  System.out.println("Ordine articolo creato");
	  }catch (DAOException exc) {
		  exc.printStackTrace();
		  fail("Creazione ordine articolo fallita");
	  }
  	}
  
  	@AfterEach
  	void tearDown() throws Exception {
  		try {
  			ordine = null;
  			utente = null;
  			articolo = null;
  			oa = null;
      
  			ArticoloDAO.getFactory().delete(conn, 10);
  			Statement stmt = conn.createStatement();
  			stmt.execute("delete from utente");
  			conn.commit();
  			System.out.println("Pulito il DB");

  		} catch (DAOException exc) {
  			exc.printStackTrace();
  			fail("Pulizia dati fallita");
  		}
  	}



}