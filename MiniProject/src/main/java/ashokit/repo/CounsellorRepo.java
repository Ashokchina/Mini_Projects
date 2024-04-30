package ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ashokit.entity.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer>{
public Counsellor findByEmailAndPwd( String email, String pwd);
public Counsellor findByemail(String email);
}
