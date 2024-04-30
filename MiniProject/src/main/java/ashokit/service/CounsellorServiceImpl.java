package ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ashokit.entity.Counsellor;
import ashokit.formbinding.DashboardResponse;
import ashokit.repo.CounsellorRepo;
@Service
public class CounsellorServiceImpl implements CounsellorService {
	@Autowired
	private CounsellorRepo crepo;

	@Override
	public String saveCounsellor(Counsellor c) {
		Counsellor obj = crepo.findByemail(c.getEmail());
		
		if(obj !=null) {
			return "Duplicate Email";
		}
		Counsellor saveobj = crepo.save(c);
		if(saveobj.getCid()!=null) {
			return "Registration Success";
		}

		return "Registration Failed";
	}

	@Override
	public Counsellor loginCheak(String email, String pwd) {
		 return crepo.findByEmailAndPwd(email, pwd);
	}
	@Override
	public boolean recoverPwd(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
