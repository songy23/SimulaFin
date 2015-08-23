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


@WebServlet("/portfolio_stockcreate")

public class Portfolio_StockCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/Portfolio_StockCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String Portfolio_ID = req.getParameter("Portfolio_ID");
    	int portfolio_Id = Integer.parseInt(Portfolio_ID);
        
        if (Portfolio_ID == null || Portfolio_ID.trim().isEmpty()) {
            messages.put("success", "Invalid Portfolio_Stock_ID");
        } else {
        	// Create the Portfolio_Stock.
        	
        	String ticker = req.getParameter("Ticker");
        	String ShareAmount = req.getParameter("ShareAmount");
        	int shareAmount = Integer.parseInt(ShareAmount);
	        try {
	        	Portfolio_Stock portfolio_Stock = new Portfolio_Stock(portfolio_Id, ticker, shareAmount);
	        	portfolio_Stock = portfolio_StockDao.create(portfolio_Stock);
	        	messages.put("success", "Successfully add new Portfolio_Stock for " + Portfolio_ID);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/Portfolio_StockCreate.jsp").forward(req, resp);
    }
}

