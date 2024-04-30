package in.ashokit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.RegistrationForm;
import in.ashokit.binding.ResetPwd;
import in.ashokit.entity.User;
import in.ashokit.props.AppProps;
import in.ashokit.service.UserServiceImpl;

@Controller
public class UserControllerImpl implements UserController {
	@Autowired
	private UserServiceImpl uService;
	@Autowired
	private AppProps props;
	
	
	
	@Override
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("login", new LoginForm());
		return "login";
	}

	@Override
	@PostMapping("/login")
	public String loginCheak(@ModelAttribute("login") LoginForm formobj, Model model) {
		User loginobj = uService.login(formobj);
		if (loginobj == null) {
			model.addAttribute("errMsg", props.getMessages().get("invalidLogin"));
			return "login";
		}
		if (loginobj.getPwdUpdated().equals("NO"))
		{
			ResetPwd resetPwd = new ResetPwd();
			resetPwd.setUserId(loginobj.getUid());
			model.addAttribute("form", resetPwd);
			return "resetPwd";
		}
		return "redirect:dash";
	}

	@Override
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("register", new RegistrationForm());
		Map<Integer,String> countries = uService.getCountries();
		
		model.addAttribute("countries", countries);
		return "register";
	}

	@Override
	@GetMapping("/logout")
	public String logout(Model model) {

		return "redirect:/";
	}

	@Override
	@GetMapping("/states")
	@ResponseBody
	public Map<Integer, String> loadStates(@RequestParam("countryId")  Integer cid) {
		 

		return uService.getstates(cid);
	}

	@Override
	@GetMapping("/cities")
	@ResponseBody
	public Map<Integer, String> loadCities(@RequestParam("stateId")  Integer sid) {
	
		 
		return uService.getCities(sid);
	}

	@Override
	@PostMapping("/register")
	public String handleUser(@ModelAttribute("register") RegistrationForm form, Model model) {
		boolean msg = uService.saveUser(form);
		
		
		if(msg) {
			
			model.addAttribute("sMsg", props.getMessages().get("Registration Success"));
		}else {
		model.addAttribute("errMsg", props.getMessages().get("regFailure"));
		
		}
		return "register";
		
		
		
	}

	@Override
	@PostMapping("/reset-pwd")
	public String updatePwd(@ModelAttribute("form") ResetPwd form, Model model) {
		if (!form.getNewPwd().equals(form.getConfirmpwd())) {

			model.addAttribute("errMsg", props.getMessages().get("invalidPwds"));
		}
		boolean status = uService.resetPwd(form);
		if (status) {
			model.addAttribute("form", new ResetPwd());
			return "dashboard";
		}
		model.addAttribute("errMsg",props.getMessages().get("updatePwdisfailed") );
		return "resetPwd";
	}

	@Override
	@GetMapping("/reset-pwd")
	public String resetPwd(Model model ,ResetPwd form) {
		
		model.addAttribute("form", new ResetPwd());
		return "resetPwd";
	}
	

}
