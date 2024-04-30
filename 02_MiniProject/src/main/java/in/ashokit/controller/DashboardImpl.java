package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.service.DashboardserviceImpl;

@Controller
public class DashboardImpl implements DashboardController {
	@Autowired
	private DashboardserviceImpl dashboardService;

	@Override
	@GetMapping("/dash")
	public String buildDashboard(Model model) {
		String quote = dashboardService.getQuote();
		model.addAttribute("msg", quote);
		
		return "dashboard";
	}

	

}
