package com.erict.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erict.architecture.dao.DAOException;
import com.erict.businesscomponent.ClientFacade;
import com.erict.businesscomponent.model.Utente;
import com.erict.security.AlgoritmoMD5;

@WebServlet("/salvadati")
public class Salvadati extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Utente utente = new Utente();
		try {
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setIndirizzo(request.getParameter("indirizzo"));
			utente.setCap(request.getParameter("cap"));
			utente.setNascita(f.parse(request.getParameter("nascita")));
			String username = request.getParameter("username");
			utente.setUsername(username);
			utente.setPassword(AlgoritmoMD5.convertiMD5(request.getParameter("password")));
			utente.setEmail(request.getParameter("email"));
			ClientFacade.getInstance().createUtente(utente);
			session.setAttribute("username", username);
			response.sendRedirect("acquisti.jsp");
		} catch(ParseException | DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}

}
