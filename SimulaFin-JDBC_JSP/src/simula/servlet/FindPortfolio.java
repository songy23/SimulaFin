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


@WebServlet("/findportfolio")
public class FindPortfolio extends HttpServlet {
	
	protected User_PortfolioDao porfoliodao;
	
	@Override
	public void init() throws ServletException {
		porfoliodao = User_PortfolioDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<User_Portfolio> portfolios = new ArrayList<User_Portfolio>();
        
        String userName = req.getParameter("userName");
        
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		portfolios = porfoliodao.getUser_PortfolioByUserName(userName);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying portfolios for " + userName);
        }
        req.setAttribute("portfolios", portfolios);
        
        req.getRequestDispatcher("/FindPortfolio.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<User_Portfolio> portfolios = new ArrayList<User_Portfolio>();
        String userName = req.getParameter("userName");
        
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		portfolios = porfoliodao.getUser_PortfolioByUserName(userName);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying portfolios for " + userName);
        }
        req.setAttribute("portfolios", portfolios);
        
        req.getRequestDispatcher("/FindPortfolio.jsp").forward(req, resp);
    }
}
