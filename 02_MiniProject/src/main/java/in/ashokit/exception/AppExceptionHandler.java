package in.ashokit.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String hadleException(Exception e, Model model) {
		model.addAttribute("msg", e.getMessage());
		return "errInfo";

	}

}
