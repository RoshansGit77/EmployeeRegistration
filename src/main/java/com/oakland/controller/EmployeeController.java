package com.oakland.controller;

import com.oakland.model.Employee;
import com.oakland.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String home() {
		return "login";
	}

	// Show Registration Page
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	// Handle Registration
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute("employee") Employee employee, Model model, HttpSession session) {
		employeeService.registerEmployee(employee);
		// model.addAttribute("message", "Registration Successful ! Please log in.");
		session.setAttribute("message", "Registration Successful ! Please log in.");

		return "redirect:/login";
	}

	// Show Login Page
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	// Handle Login
	@PostMapping("/login")
	public String loginEmployee(@RequestParam String loginId, @RequestParam String password, Model model,
			HttpSession session) {
		Employee employee = employeeService.getEmployeeByLoginIdAndPassword(loginId, password);
		if (employee != null) {
			session.setAttribute("loggedInUser", employee);
			model.addAttribute("msg", "Login Successful !");
			return "redirect:/welcome";
		} else {
			model.addAttribute("msg", "Invalid Credentials ! Try Again.");
			return "login";
		}
	}

	// Show Welcome Page with List of Employees
	@GetMapping("/welcome")
	public String showWelcomePage(Model model, HttpSession session) {
		Employee loggedInUser = (Employee) session.getAttribute("loggedInUser");
		if (loggedInUser == null) {
			return "redirect:/login";
		}

		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("employees", employees);
		return "welcome";
	}

	// Handle Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
