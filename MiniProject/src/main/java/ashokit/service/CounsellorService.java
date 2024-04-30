package ashokit.service;

import ashokit.entity.Counsellor;
import ashokit.formbinding.DashboardResponse;

public interface CounsellorService {
public String saveCounsellor(Counsellor c) ;
public Counsellor loginCheak(String email,String pwd);
public boolean recoverPwd(String email);
public DashboardResponse getDashboardInfo(Integer cid);

}
