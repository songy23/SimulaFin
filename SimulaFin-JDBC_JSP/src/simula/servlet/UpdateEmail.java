package simula.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simula.dal.*;
import simula.model.User;

@WebServlet("/updateemail")

public class UpdateEmail extends HttpServlet {
	
	protected UserDao usersDao;
	
	@Override
	public void init() throws ServletException {
		usersDao = UserDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String userName = req.getParameter("userName");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		User user = usersDao.getUserByUser_Name(userName);
        		if(user == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		req.setAttribute("User", user);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UpdateEmail.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String userName = req.getParameter("userName");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		User user = usersDao.getUserByUser_Name(userName);
        		if(user == null) {
        			messages.put("success", "UserName does not exist. No update to perform.");
        		} else {
        			String newEmail = req.getParameter("Email");
        			if (newEmail == null || newEmail.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid Email.");
        	        } else {
        	        	user = usersDao.updateEmail(user, newEmail);
        	        	messages.put("success", "Successfully updated " + userName + " Email");
        	        }
        		}
        		req.setAttribute("User", user);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/UpdateEmail.jsp").forward(req, resp);
    }
}