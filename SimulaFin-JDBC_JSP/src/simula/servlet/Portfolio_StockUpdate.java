package simula.servlet;

import simula.dal.*;
import simula.model.Portfolio_Stock;
import simula.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


@WebServlet("/portfolio_stockupdate")
public class Portfolio_StockUpdate extends HttpServlet {
	
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

        // Retrieve user and validate.
        String Portfolio_Stock_Id = req.getParameter("Portfolio_Stock_Id");
        
        if (Portfolio_Stock_Id == null || Portfolio_Stock_Id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Portfolio_Stock_Id.");
        } else {
        	try {
        		int portfolio_Stock_Id = Integer.parseInt(Portfolio_Stock_Id);
        		Portfolio_Stock portfolio_Stock = portfolio_StockDao.getPortfolio_StockByPortfolio_Stock_Id(portfolio_Stock_Id);
        		if(portfolio_Stock == null) {
        			messages.put("success", "Portfolio_Stock_Id does not exist.");
        		}
        		req.setAttribute("Portfolio_Stock", portfolio_Stock);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/Portfolio_StockUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String Portfolio_Stock_Id = req.getParameter("Portfolio_Stock_Id");
        int portfolio_Stock_Id = Integer.parseInt(Portfolio_Stock_Id);
        if (Portfolio_Stock_Id == null || Portfolio_Stock_Id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Portfolio_Stock_Id.");
        } else {
        	try {
        		Portfolio_Stock portfolio_Stock = portfolio_StockDao.getPortfolio_StockByPortfolio_Stock_Id(portfolio_Stock_Id);
        		if(portfolio_Stock == null){
        			messages.put("success", "portfolio_Stock does not exist. No update to perform.");
        		} else {
        			String newTicker = req.getParameter("Ticker");
        			if (newTicker == null || newTicker.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid Ticker.");
        	        } else {
        	        	portfolio_Stock = portfolio_StockDao.updateTicker(portfolio_Stock, newTicker);
        	        }
        			
        			String newShareAmount = req.getParameter("ShareAmount");
        			int newshareamount = Integer.parseInt(newShareAmount);
        			if (newShareAmount == null || newShareAmount.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid ShareAmount.");
        	        } else {
        	        	portfolio_Stock = portfolio_StockDao.updateShareamount(portfolio_Stock, newshareamount);
        	        	messages.put("success", "Successfully updated with new ticker " + newTicker +
        	        			" and new shareamount " + newshareamount);
        	        }
        		}
        		req.setAttribute("Portfolio_Stock", portfolio_Stock);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/Portfolio_StockUpdate.jsp").forward(req, resp);
    }
}