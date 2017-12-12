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
	public String showProfile() {
		return "profilepage";
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