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


@WebServlet("/portfoliocreate")

public class PortfolioCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/PortfolioCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.

    	String userName = req.getParameter("userName");
        
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid UserName");
        } else {
        	// Create the Portfolio.
        	String portfolio_Name = req.getParameter("portfolio_Name");
	        try {
	        	User_Portfolio user_Portfolio = new User_Portfolio(userName, portfolio_Name);
	        	user_Portfolio = user_PortfolioDao.create(user_Portfolio);
	        	messages.put("success", "Successfully created " + portfolio_Name);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/PortfolioCreate.jsp").forward(req, resp);
    }
}
