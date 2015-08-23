package simula.servlet;

import simula.dal.*;
import simula.model.User_Portfolio;
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


@WebServlet("/portfolioupdate")

public class PortfolioUpdate  extends HttpServlet {
	
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

        // Retrieve user and validate.
        String Portfolio_Id = req.getParameter("Portfolio_Id");
        
        if (Portfolio_Id == null || Portfolio_Id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Portfolio_Id.");
        } else {
        	try {
        		int portfolio_Id = Integer.parseInt(Portfolio_Id);
        		User_Portfolio user_Portfolio = user_PortfolioDao.getUser_PortfolioByPortfolio_Id(portfolio_Id);
        		if(user_Portfolio == null) {
        			messages.put("success", "user_Portfolio does not exist.");
        		}
        		req.setAttribute("User_Portfolio", user_Portfolio);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/PortfolioUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String Portfolio_Id = req.getParameter("Portfolio_Id");
        int portfolio_Id = Integer.parseInt(Portfolio_Id);
        if (Portfolio_Id == null || Portfolio_Id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Portfolio_Id.");
        } else {
        	try {
        		User_Portfolio user_Portfolio = user_PortfolioDao.getUser_PortfolioByPortfolio_Id(portfolio_Id);
        		if(user_Portfolio == null) {
        			messages.put("success", "user_Portfolio does not exist. No update to perform.");
        		} else {
        			String newPortfolio_Name = req.getParameter("Portfolio_Name");
        			if (newPortfolio_Name == null || newPortfolio_Name.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid Portfolio_Name.");
        	        } else {
        	        	user_Portfolio = user_PortfolioDao.updatePortfolio_Name(user_Portfolio, newPortfolio_Name);
        	        	messages.put("success", "Successfully updated " + newPortfolio_Name);
        	        }
        		}
        		req.setAttribute("User_Portfolio", user_Portfolio);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/PortfolioUpdate.jsp").forward(req, resp);
    }
}