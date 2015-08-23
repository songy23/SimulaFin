package simula.servlet;

import simula.dal.*;
import simula.model.Historical_Price;
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


@WebServlet("/findhistorical_price")
public class FindHistorical_Price extends HttpServlet {
	
	protected Historical_PriceDao historical_PriceDao;
	
	@Override
	public void init() throws ServletException {
		historical_PriceDao = Historical_PriceDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Historical_Price> historical_Prices = new ArrayList<Historical_Price>();
        
        String ticker = req.getParameter("Ticker");
        if (ticker == null || ticker.trim().isEmpty()) {
            messages.put("success", "Please enter a valid ticker.");
        } else {
        	try {
        		historical_Prices = historical_PriceDao.getHistorical_PricebyTicker(ticker);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying historical prices for " + ticker);
  
        	messages.put("previousTicker", ticker);
        }
        req.setAttribute("historical_Prices", historical_Prices);
        
        req.getRequestDispatcher("/FindHistorical_Price.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Historical_Price> historical_Prices = new ArrayList<Historical_Price>();
        
        String ticker = req.getParameter("Ticker");
        if (ticker == null || ticker.trim().isEmpty()) {
            messages.put("success", "Please enter a valid ticker.");
        } else {
        	try {
        		historical_Prices = historical_PriceDao.getHistorical_PricebyTicker(ticker);
            }catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying historical prices for " + ticker);
        }
        req.setAttribute("historical_Prices", historical_Prices);
        
        req.getRequestDispatcher("/FindHistorical_Price.jsp").forward(req, resp);
    }
}
