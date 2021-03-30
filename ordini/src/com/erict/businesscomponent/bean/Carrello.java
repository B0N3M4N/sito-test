package com.erict.businesscomponent.bean;

import java.util.Enumeration;
import java.util.Hashtable;

public class Carrello {

  private Hashtable<String, String[]> prodotti;
  private int articoli;

  public Carrello() {
    prodotti = new Hashtable<>();
    articoli = 0;
  }

  public int getArticoli() {
    return articoli;
  }

  // Metodo di controllo di aggiunta dei prodotti
  public void aggiungiArticolo(String id, String marca, String modello, double prezzo) {
    String[] record = { marca, modello, Double.toString(prezzo), "1", id }; // "1" è la quantità
    articoli++;
    if (prodotti.containsKey(id)) {
      String dati[] = prodotti.get(id);
      int quantita = Integer.parseInt(dati[3]);
      quantita++;
      dati[3] = Integer.toString(quantita);
      prodotti.put(id, dati);
    } else {
      prodotti.put(id, record);
    }
  }

  // Se rimane un solo articolo rimuove dalla mappa altrimenti decrementa quantità
  public void rimuoviArticolo(String id) {
    if (prodotti.containsKey(id)) {
      articoli--;
      String[] dati = prodotti.get(id);
      if (Integer.parseInt(dati[3]) == 1)
        prodotti.remove(id);
      else {
        int quantita = Integer.parseInt(dati[3]);
        quantita--;
        dati[3] = Integer.toString(quantita);
        prodotti.put(id, dati);
      }
    }
  }

  public double totaleComplessivo() {
    double totale = 0.00;
    // Ritorno tutti i valori associate alle chiavi
    Enumeration<String[]> enumerazione = prodotti.elements();
    String[] dati;
    while (enumerazione.hasMoreElements()) {
      dati = enumerazione.nextElement();
      totale += Double.parseDouble(dati[2]) * Integer.parseInt(dati[3]);
    }

    return totale;
  }

  public double totaleParziale(String id) {

    // Prendo prodotto con chiave id
    String[] dati = prodotti.get(id);

    return Double.parseDouble(dati[2]) * Integer.parseInt(dati[3]);

  }
  
  //ritorna lista dei prodotti
  public Enumeration<String[]> getProdotti() {
    
    return prodotti.elements();
  }

}