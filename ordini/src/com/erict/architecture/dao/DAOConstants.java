package com.erict.architecture.dao;

public interface DAOConstants {
	String SELECT_UTENTE = "select * from utente";
	String SELECT_ORDINE = "select * from ordine";
	String SELECT_ARTICOLO = "select * from articolo";
	String SELECT_ORDINEARTICOLO = "select * from ordine_articolo";
	String SELECT_IMMAGINE = "select * from immagine";
	
	String SELECT_USERPASS = "Select password from utente where username = ?";
	String SELECT_ADMINPASS = "Select password from amministratore where username = ?";
	
	String SELECT_ORDINESEQ = "Select ordine_seq.nextval from dual";
	String SELECT_ARTICOLOSEQ = "Select articolo_seq.nextval from dual";
	String SELECT_IMMAGINEOSEQ = "Select immagine_seq.nextval from dual";
	
	String SELECT_ARTICOLO_BY_ID = "select * from articolo where id_articolo = ?";
	
	String UPDATE_ARTICOLO = "Update articolo set marca = ?, modello = ?, prezzo = ? where id_articolo = ?";
	
	String DELETE_ORDINE = "delete from ordine where id_ordine = ?";
	String DELETE_ARTICOLO = "delete from articolo where id_articolo = ?";
	
	String INSERT_ORDINEARTICOLO = "insert into ordine_articolo values (?,?,?)";
	
	String SELECT_REPORT = "Select * from report";
}
