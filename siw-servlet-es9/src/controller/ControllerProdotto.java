package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prodotto;
import service.ProductService;
import validator.ProductValidator;

@WebServlet("/prodotto")
public class ControllerProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)                
			throws ServletException, IOException {           
		   
		String nextPage = null;
		request.setAttribute("dateFormat", this.getDatePattern());
		
		if(request.getParameter("command").equals("rimuovi")) {
			long id = Long.parseLong(request.getParameter("id"));
			ProductService pv = new ProductService();
			pv.deleteProdotto(id);
			request.setAttribute("prodotti", pv.getProdotti());
			nextPage = "/prodotti.jsp";
		}
		if(request.getParameter("command").equals("invia")) {
			Prodotto prodotto = new Prodotto();
			request.setAttribute("prodotto", prodotto);
		
			ProductValidator validator = new ProductValidator();
			if(validator.validate(request)) {
				HttpSession session = request.getSession();
				session.setAttribute("prodotto", prodotto);
				session.setAttribute("dateFormat", this.getDatePattern());
			
				nextPage = "/conferma.jsp";
			} else {
				nextPage = "/index.jsp";
			}
		}
		
		ServletContext application= getServletContext();           
		RequestDispatcher rd= application.getRequestDispatcher(nextPage);          
		rd.forward(request, response);            
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ProductService service = new ProductService();
		String nextPage;
		request.setAttribute("dateFormat", this.getDatePattern());
		
		if(request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			Prodotto prodotto = service.getOneProdotto(id);
			
			request.setAttribute("prodotto", prodotto);
			
			nextPage = "/prodotto.jsp";
		} else {
		
			List<Prodotto> prodotti = service.getProdotti();
			request.setAttribute("prodotti", prodotti);
		
			nextPage = "/prodotti.jsp";
		}
		
		ServletContext application= getServletContext();           
		RequestDispatcher rd= application.getRequestDispatcher(nextPage);          
		rd.forward(request, response);   
	}
	
	private String getDatePattern() {
		return "dd-MM-yyyy";
	}
}
