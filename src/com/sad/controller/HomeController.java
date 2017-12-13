package com.sad.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sad.dao.UsersDaoImpl;
import com.sad.dto.Users;

@Controller
public class HomeController {
	
	@RequestMapping(value= {"/","/index"})
	public String helloWorld() {
		String password = BCrypt.hashpw("admin", BCrypt.gensalt(15));
		System.out.println("pw:"+password);
		return "index";
	}
	@RequestMapping("/dashboard")
	public String showDashboard(HttpSession session,Model model) {
			
		if (session.getAttribute("user") == null) {
			
			return "loginPage";
		}
		else {
		Users user = (Users)session.getAttribute("user");
		model.addAttribute("profileName", "Hello, " + user.getFirstName());
		
		DController dControl = new DController();
		try {
			DController.emotionChart(model);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MikeHomeController mikecontroller = new MikeHomeController();
		mikecontroller.visualizeFeeling(model);
		
		return "dashboard";
		}
	}
	
	@RequestMapping("/profilepage")
	public String showProfile(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			showDashboard(session, model);
			return "loginPage";
		}
		Users user = (Users)session.getAttribute("user");
		
		String message = ("<h1 class='pageTitle'>PROFILE</h1>");
		message += ("<h2>"+user.getFirstName()+" "+user.getLastName()+"</h2>");
		message += ("<p>"+user.getEmail()+"</p>");
		message += ("<a href='editprofile'>Edit Profile</a>");
		
		model.addAttribute("profile", message);
		
		return "profilepage";
	}
	
	@RequestMapping("/editprofile")
	public String editProfile(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			showDashboard(session, model);
			return "loginPage";
		}
		Users user = (Users)session.getAttribute("user");
		
		String message = ("<h1 class='pageTitle'>EDIT PROFILE</h1>");
		message += ("<form action='updateUser' method='post'>");
		message += ("<input type='text' name='firstName' placeholder='"+user.getFirstName()+"'><br> ");
		message += ("<input type='text' name='lastName' placeholder='"+user.getLastName()+"'><br> ");
		message += ("<input type='email' name='email' placeholder='"+user.getEmail()+"'><br> ");
		message += ("<input type='password' pattern='.{6,}' title='Six or more characters.' id='password' name='password' placeholder='New Password'><br> ");
		message += ("<input type='password' id='confirm_password' name='password2' placeholder='Confirm Password'><br> ");
		message += ("<input type='submit' value='UPDATE'></form>");

		


		message += ("<p>"+user.getEmail()+"</p>");
		message += ("<a href='editprofile'>Edit Profile</a>");
		
		model.addAttribute("editprofile", message);
		
		return "editprofile";
	}
	@RequestMapping("/updateUser")
	public String updateUser(HttpSession session, Model model, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("password") String password) {
		if (session.getAttribute("user") == null) {
			showDashboard(session, model);
			return "loginPage";
		}
		Users user = (Users)session.getAttribute("user");
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);

		UsersDaoImpl transfer = new UsersDaoImpl();
		transfer.updateUsers(user);
		
		session.setAttribute("user", user);
		
		return "profilePage";
	}

	@RequestMapping("/loginPage")
	public String showLogin() {
		return "loginPage";
	}
	
	@RequestMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		
		if (session.getAttribute("user") != null) {
			showDashboard(session, model);
			return "dashboard";
		}
		UsersDaoImpl users = new UsersDaoImpl();

		ArrayList<Users> list = users.getAllUsers("email", email);

		String webPage = "loginPage";

		if (!list.isEmpty()) {

			String dbPassword = list.get(0).getPassword();

			if (BCrypt.checkpw(password, dbPassword)) {
				model.addAttribute("firstName", list.get(0).getFirstName());
				session.setAttribute("user", list.get(0));
				showDashboard(session, model);
				return "dashboard";
			} else {
				String alert = "<script>alert('Password is incorrect. Try again.')</script>";
				model.addAttribute("alert", alert);
			}
		} else {
			String alert = "<script>alert('Username does not exist. Try again.')</script>";
			model.addAttribute("alert", alert);
		}

		return webPage;
	}
}