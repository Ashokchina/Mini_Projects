package in.ashokit.controller;

import java.util.Map;

import org.springframework.ui.Model;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.RegistrationForm;
import in.ashokit.binding.ResetPwd;

public interface UserController {
public String index(Model model);
public String loginCheak(LoginForm objform, Model model);
public String register(Model model);
public String resetPwd(Model model,ResetPwd form);
public String logout(Model model);
public Map<Integer, String>loadStates(Integer cid);
public Map<Integer, String>loadCities(Integer sid);
public String handleUser(RegistrationForm form,Model model);
public String updatePwd(ResetPwd form ,Model model);

}
