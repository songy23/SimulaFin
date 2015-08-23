package simula.servlet;

import simula.dal.*;
import simula.model.*;

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

@WebServlet("/findstock")
public class FindStock extends HttpServlet {
	
	protected StockDao stockdao;
	
    protected Stock_StatDao statdao;
	
	@Override
	public void init() throws ServletException {
		stockdao = StockDao.getInstance();
		statdao = Stock_StatDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Stock stock = new Stock();
        Stock_Stat stat = new Stock_Stat();
        
        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String ticker = req.getParameter("ticker");
        if (ticker == null || ticker.trim().isEmpty()) {
            messages.put("success", "Please enter a valid ticker.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	stock = stockdao.getStockbyTicker(ticker);
            	stat = statdao.getStock_StatbyTicker(ticker);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + ticker);
        }
        req.setAttribute("stock", stock);
        req.setAttribute("stat", stat);
        
        req.getRequestDispatcher("/FindStock.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Stock stock = new Stock();
        Stock_Stat stat = new Stock_Stat();
        
        
        // Retrieve and validate name.
        // firstname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String ticker = req.getParameter("ticker");
        if (ticker == null || ticker.trim().isEmpty()) {
            messages.put("success", "Please enter a valid ticker.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	stock = stockdao.getStockbyTicker(ticker);
            	stat = statdao.getStock_StatbyTicker(ticker);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + ticker);
        }
        req.setAttribute("stock", stock);
        req.setAttribute("stat", stat);
        
        
        req.getRequestDispatcher("/FindStock.jsp").forward(req, resp);
    }
}
