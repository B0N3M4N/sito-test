package com.erict.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erict.architecture.dao.DAOException;
import com.erict.businesscomponent.ClientFacade;


@WebServlet("/rimuoviArticolo")
public class EliminaArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			if(id != null) {
				ClientFacade.getInstance().deleteArticolo(Long.valueOf(id));
			}
			response.sendRedirect("acquisti.jsp");	
		} catch(DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
