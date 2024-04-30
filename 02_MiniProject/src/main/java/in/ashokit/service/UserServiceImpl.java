
package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.RegistrationForm;
import in.ashokit.binding.ResetPwd;
import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.entity.State;
import in.ashokit.entity.User;
import in.ashokit.repo.CityRepo;
import in.ashokit.repo.CountryRepo;
import in.ashokit.repo.StateRepo;
import in.ashokit.repo.UserRepo;
import in.ashokit.utils.EmailUtils;
@Service
public class UserServiceImpl implements UserService{
	Random random = new Random();
	@Autowired
private UserRepo urepo;
	@Autowired
private CountryRepo crepo;
	@Autowired
private StateRepo srepo;
	@Autowired
private CityRepo cityRepo;
	@Autowired
	private EmailUtils emailUtils;
	@Override
	public Map<Integer, String> getCountries() {
		Map<Integer, String >countrieslist=new HashMap<>();
		List<Country> findAll = crepo.findAll();
		findAll.forEach(c->{
			countrieslist.put(c.getCid(), c.getCname());
		});
		return countrieslist;
		
	}
	@Override
	public Map<Integer, String> getstates(Integer cid) {
		Map<Integer, String> statesmap= new HashMap<>();
		
		List<State>stateslist = srepo.findStatesByCid(cid);
		stateslist.forEach(s->{
			statesmap.put(s.getSid(),s.getSname());
		});
		return statesmap;
	}
	@Override
	public Map<Integer, String> getCities(Integer sid) {
		Map<Integer, String> Citiesmap = new HashMap<>();
		List<City> citieslist = cityRepo.findBySid(sid);
		citieslist.forEach(c->{
			Citiesmap.put(c.getCityid(),c.getCityname());
		});
		return Citiesmap;
	}
	@Override
	public User getUser(String email) {
		User findByEmail = urepo.findByEmail(email);
		return findByEmail;
	}
	@Override
	public boolean saveUser(RegistrationForm formobj) {
		User userEntity = new User();
		formobj.setPwd(generateRandompwd());
		formobj.setPwdUpdated("NO");
		BeanUtils.copyProperties(formobj, userEntity);
		generateRandompwd();
		urepo.save(userEntity);
		String subject="Your Account is Created";
		String body ="<h1>"+"Your password :"+formobj.getPwd()+"</h1>";
				
		return emailUtils.sendEmail(subject, body, formobj.getEmail());
	}
	private String generateRandompwd() {
		
		    String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";
		 
		    StringBuffer randomString = new StringBuffer(5);
		    
		 
		    for (int i = 0; i < 5; i++) {
		        int randomIndex = random.nextInt(alphanumericCharacters.length());
		        char randomChar = alphanumericCharacters.charAt(randomIndex);
		        randomString.append(randomChar);
		    }
		 
		    return randomString.toString();
		}
		
	
	@Override
	public User login(LoginForm formobj) {
		User byEmailandPwd = urepo.findByEmailAndPwd(formobj.getEmail(), formobj.getPassword());
		return byEmailandPwd;
	}
	@Override
	public boolean resetPwd(ResetPwd formobj) {
		Optional<User> findById = urepo.findById(formobj.getUserId());
		
		if(findById.isPresent()) {
			User user = findById.get();
			user.setPwd(formobj.getNewPwd());
			user.setPwdUpdated("YES");
			 urepo.save(user);
			return true;
		}
		return false;
	}
	
	
	
}
