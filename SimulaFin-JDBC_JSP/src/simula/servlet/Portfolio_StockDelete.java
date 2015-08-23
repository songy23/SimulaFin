package simula.servlet;

import simula.dal.*;
import simula.model.Portfolio_Stock;
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


@WebServlet("/portfolio_stockdelete")

public class Portfolio_StockDelete extends HttpServlet {
	
	protected Portfolio_StockDao portfolio_StockDao;
	
	@Override
	public void init() throws ServletException {
		portfolio_StockDao = Portfolio_StockDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete Portfolio_Stock");        
        req.getRequestDispatcher("/Portfolio_StockDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String portfolio_Stock_ID = req.getParameter("Portfolio_Stock_ID");
        int portfolio_Stock_Id = Integer.parseInt(portfolio_Stock_ID);
        if (portfolio_Stock_ID == null || portfolio_Stock_ID.trim().isEmpty()) {
            messages.put("title", "Invalid Portfolio_Stock_ID");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
        	Portfolio_Stock portfolio_Stock = new Portfolio_Stock(portfolio_Stock_Id);
	        try {
	        	portfolio_Stock = portfolio_StockDao.delete(portfolio_Stock);
	        	// Update the message.
		        if (portfolio_Stock == null) {
		            messages.put("title", "Successfully deleted Portfolio_Stock whose Id is" + portfolio_Stock_Id);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + portfolio_Stock_Id);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/Portfolio_StockDelete.jsp").forward(req, resp);
    }
}
