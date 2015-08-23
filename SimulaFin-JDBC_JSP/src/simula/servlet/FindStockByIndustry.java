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

@WebServlet("/findstockbyindustry")

public class FindStockByIndustry extends HttpServlet {
	
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

        List<Stock> stocks = new ArrayList<Stock>();
        
        String industry = req.getParameter("Industry");
        if (industry == null || industry.trim().isEmpty()) {
            messages.put("success", "Please enter a valid industry.");
        } else {
        	try {
            	stocks = stockdao.getStockByIndustry(industry);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying stocks for " + industry);
        }
        req.setAttribute("stocks", stocks);
        
        req.getRequestDispatcher("/FindStockByIndustry.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

List<Stock> stocks = new ArrayList<Stock>();
        
        String industry = req.getParameter("Industry");
        if (industry == null || industry.trim().isEmpty()) {
            messages.put("success", "Please enter a valid industry.");
        } else {
        	try {
            	stocks = stockdao.getStockByIndustry(industry);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying stocks for " + industry);
        }
        req.setAttribute("stocks", stocks);
        
        req.getRequestDispatcher("/FindStockByIndustry.jsp").forward(req, resp);
    }
}