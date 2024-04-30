package ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ashokit.entity.StudentEnq;
import ashokit.formbinding.SearchCriteria;
import ashokit.service.EnquiryService;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService eService;
	@GetMapping("/enquiry")
	public String enqPage(Model model) {
		model.addAttribute("enq", new StudentEnq());
		return "addEnqview";
		
	}
@PostMapping("/enquiry")
	public String addEnquiry(StudentEnq se, Model model) {
		return "addEnqview";
		
	}
@GetMapping("/enquiries")
	public String viewEnquiries(Model model) {
		List<StudentEnq> enqurieslist = eService.getEnquries(null);
		model.addAttribute("enquiries", enqurieslist);
		return "displayEnqView";
		
	}
@PostMapping("/filter-enquries")
	public String filterEnquiries(SearchCriteria sc, Model model) {
	List<StudentEnq> enqurieslist = eService.getEnquries(null);
	model.addAttribute("enquiries", enqurieslist);
		return "displayEnqView";
		
	}

}
