package com.it15301.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it15301.entity.Account;
import com.it15301.repositories.AccountRepository;
import com.it15301.utilities.HashUtil;

@Controller
public class LoginController {
	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/shopcat/login")
	public String getLoginForm() {
		return "/shopcat/login";
	}
	
	@PostMapping("/shopcat/login")
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password
	) {
		Account entity = (Account) this.accRepo.findAll();
		HttpSession session = request.getSession();
		if (entity.getEmail() == null) {
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			return "redirect:/shopcat/login";
		}

//		boolean checkPwd = HashUtil.verify(password, entity.getPassword());
//		if (!checkPwd) {
//			session.setAttribute("error", "Sai email hoặc mật khẩu");
//			return "redirect:/shopcat/login";
//		}
		
		if(entity.getEmail()=="") {//....
			session.setAttribute("user", entity);
			return "redirect:/shopcat/admin";
		}else {
			session.setAttribute("user", entity);
			return "redirect:/shopcat/user";
		}
		
	}
}
