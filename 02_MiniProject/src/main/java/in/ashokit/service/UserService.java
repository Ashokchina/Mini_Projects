package in.ashokit.service;

import java.util.Map;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.RegistrationForm;
import in.ashokit.binding.ResetPwd;
import in.ashokit.entity.User;

public interface UserService {
public Map<Integer, String> getCountries( );
public Map<Integer, String> getstates(Integer cid);
public Map<Integer, String> getCities(Integer sid);
public User getUser(String email);
public boolean saveUser(RegistrationForm formobj);
public User login(LoginForm formobj);
public boolean resetPwd(ResetPwd formobj);
}
