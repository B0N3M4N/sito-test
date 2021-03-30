package com.erict.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erict.architecture.dao.DAOException;
import com.erict.businesscomponent.ClientFacade;
import com.erict.businesscomponent.bean.Carrello;
import com.erict.businesscomponent.model.Ordine;
import com.erict.businesscomponent.model.OrdineArticolo;

/**
 * Servlet implementation class Conferma
 */
@WebServlet("/conferma")
public class Conferma extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello)session.getAttribute("carrello");
		Ordine ord = new Ordine();
		ord.setTotale(carrello.totaleComplessivo());
		ord.setUsername((String)session.getAttribute("username"));
		
		try {
			ClientFacade cF = ClientFacade.getInstance();
			cF.createOrdine(ord);
			OrdineArticolo oa;
			Enumeration<String[]> prodotti = carrello.getProdotti();
			while(prodotti.hasMoreElements()) {
				oa = new OrdineArticolo();
				String [] p = prodotti.nextElement();
				oa.setIdOrdine(ord.getIdOrdine());
				oa.setIdArticolo(Long.parseLong(p[4]));
				oa.setQuantita(Integer.parseInt(p[3]));
				cF.createOrdineArticolo(oa);
			}
			session.setAttribute("idordine", ord.getIdOrdine());
			response.sendRedirect("ordine.jsp");
		} catch(DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
