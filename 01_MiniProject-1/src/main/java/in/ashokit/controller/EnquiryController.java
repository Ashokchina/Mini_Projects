package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.SearchCriteria;
import in.ashokit.entity.StudentEnq;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService enqService;

	@GetMapping("/addenquiry")
	public String enqpage(Model model) {
		model.addAttribute("enq", new StudentEnq());
		return "addEnqView";
	}
	
	@PostMapping("/enquiry")
	public String addEnquries(@ModelAttribute("enq") StudentEnq enq, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("CID");
		if (cid == null) {
			return "redirect:/logout";
		}
		enq.setCid(cid);
		boolean addEnq = enqService.addEnq(enq);
		if (addEnq) {
			model.addAttribute("succMsg", "Enquiry Added");

		} else {
			model.addAttribute("errMsg", "Enquiry Failed To Add");

		}
		return "addEnqView";
	}

	@GetMapping("/view-enquiries")
	public String viewEnquries(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("CID");

		if (cid == null) {
			return "redirect:/logout";
		}
		List<StudentEnq> enquiriesList = enqService.getEnquiries(cid, new SearchCriteria());
		model.addAttribute("enquiries", enquiriesList);
		model.addAttribute("sc", new SearchCriteria()); 
		return "DisplayEnqView";
	}

	@PostMapping("/filter-enquiries")
	public String filterEnquiries(@ModelAttribute("sc") SearchCriteria sc, HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("CID");

		if (cid == null) {
			return "redirect:/view-enquiries";
		}

		List<StudentEnq> enquiriesList = enqService.getEnquiries(cid, sc);

		model.addAttribute("enquiries", enquiriesList);

		return "filterEnqView";
	}

}
