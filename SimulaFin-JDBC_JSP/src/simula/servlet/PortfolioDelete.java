package simula.servlet;

import simula.dal.*;
import simula.model.User_Portfolio;
import simula.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/portfoliodelete")
public class PortfolioDelete extends HttpServlet {
	
	protected User_PortfolioDao user_PortfolioDao;
	
	@Override
	public void init() throws ServletException {
		user_PortfolioDao = User_PortfolioDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete User_Portfolio");        
        req.getRequestDispatcher("/PortfolioDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String portfolio_ID = req.getParameter("portfolio_ID");
        int portfolio_Id = Integer.parseInt(portfolio_ID);
        if (portfolio_ID == null || portfolio_ID.trim().isEmpty()) {
            messages.put("title", "Invalid Portfolio_ID");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
        	User_Portfolio user_portfolio = new User_Portfolio(portfolio_Id);
	        try {
	        	user_portfolio = user_PortfolioDao.delete(user_portfolio);
	        	// Update the message.
		        if (user_portfolio == null) {
		            messages.put("title", "Successfully deleted Portfolio whose Id is " + portfolio_Id);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + portfolio_Id);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/PortfolioDelete.jsp").forward(req, resp);
    }
}
