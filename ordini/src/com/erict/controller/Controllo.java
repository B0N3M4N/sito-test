package com.erict.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erict.architecture.dao.DAOException;
import com.erict.businesscomponent.utilities.LoginUtility;
import com.erict.security.AlgoritmoMD5;

/**
 * Servlet implementation class controllo
 */
@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username	= request.getParameter("username");
		String password = AlgoritmoMD5.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String userpass, adminpass;
		
		if(username != null && password != null) {
			try {
				LoginUtility lu = new LoginUtility();
				userpass = lu.getUserPass(username);
				adminpass = lu.getAdminPass(username);
				
				if(userpass!=null) {
			          if(userpass.equals(password)) {
			            //settiamo la sessione dell utente
			            session.setAttribute("username", username);
			            response.sendRedirect("acquisti.jsp");
			          }else {
			            response.sendRedirect("accessonegato.jsp");
			          }
			        }else if(adminpass!=null) {
			          if(adminpass.equals(password)) {
			            session.setAttribute("admin", username);
			            response.sendRedirect("admin/admin.jsp");
			          }else {
			            response.sendRedirect("accessonegato.jsp");
			          }
			        }else {
			          response.sendRedirect("accessonegato.jsp");
			        }
			    }catch(DAOException | ClassNotFoundException exc) {
			      exc.printStackTrace();
			      throw new ServletException(exc.getMessage());
			    }
		}
		
		}

}
