package ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ashokit.entity.Counsellor;
import ashokit.service.CounsellorService;

@Controller
public class CounsellorsController {
	@Autowired
	private CounsellorService cService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "loginview";

	}

	@PostMapping("/login")
	public String handleLogin(Counsellor c, Model model) {
		Counsellor obj = cService.loginCheak(c.getEmail(), c.getPwd());
		if ( c == null) {
			model.addAttribute("errMsg", "Invalid Credentials");
			return "loginview";
		}
		return "redirect:dashboard";

	}

	@GetMapping("/register")
	public String regPage(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "registerview";

	}

	@PostMapping("/register")
	public String handleRegistration(Counsellor c, Model model) {
		String msg = cService.saveCounsellor(c);
		model.addAttribute("msg", msg);
		return "registerview";

	}

	@GetMapping("/forgot-pwd")
	public String recoverPwdPage(Model model) {

		return "forgotpwdview";
	}

	@GetMapping("/dashboard")
	public String buildDashboard(Model model) {

		return "dashboardview";
	}
	public String recoverPwd(String email,Model model) {
		boolean status = cService.recoverPwd(email);
		if(status) {
			model.addAttribute("smsg","Pwd sent to your email");
			}else {
				model.addAttribute("errmsg", "Invalid Email");
			}
		return "forgotpwdview";
	}
}
