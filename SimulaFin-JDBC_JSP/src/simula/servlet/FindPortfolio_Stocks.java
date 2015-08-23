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


@WebServlet("/findportfolio_stock")

public class FindPortfolio_Stocks extends HttpServlet {
	
	protected Portfolio_StockDao porfolio_stockdao;
	
	@Override
	public void init() throws ServletException {
		porfolio_stockdao = Portfolio_StockDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Portfolio_Stock> portfolio_stocks = new ArrayList<Portfolio_Stock>();
        
        String portfolio_id_s = req.getParameter("portfolio_id");      
        int portfolio_id = Integer.parseInt(portfolio_id_s);
        
        if (portfolio_id_s == null || portfolio_id_s.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Portfolio_ID.");
        } else {
        	try {
        		portfolio_stocks = porfolio_stockdao.getPortfolio_StockByPortfolio_Id(portfolio_id);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying stocks for portflio " + portfolio_id);
        }
        req.setAttribute("portfolio_stocks", portfolio_stocks);
        
        req.getRequestDispatcher("/FindPortfolio_Stock.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

List<Portfolio_Stock> portfolio_stocks = new ArrayList<Portfolio_Stock>();
        
        String portfolio_id_s = req.getParameter("portfolio_id");      
        int portfolio_id = Integer.parseInt(portfolio_id_s);
        
        if (portfolio_id_s == null || portfolio_id_s.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Portfolio_ID.");
        } else {
        	try {
        		portfolio_stocks = porfolio_stockdao.getPortfolio_StockByPortfolio_Id(portfolio_id);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying stocks for portflio " + portfolio_id);
        }
        req.setAttribute("portfolio_stocks", portfolio_stocks);
        
        req.getRequestDispatcher("/FindPortfolio_Stock.jsp").forward(req, resp);
    }
}
