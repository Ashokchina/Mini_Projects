package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.binding.SearchCriteria;
import in.ashokit.entity.StudentEnq;
import in.ashokit.repo.StudentEnqRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {
@Autowired
	private StudentEnqRepo srepo;

	@Override
	public boolean addEnq(StudentEnq se) {
		
		StudentEnq savedEnq = srepo.save(se);
		return savedEnq.getEnqId() != null;
	}

	@Override
	public List<StudentEnq> getEnquiries(Integer cid, SearchCriteria s) {
		StudentEnq enq = new StudentEnq();
		enq.setCid(cid);
		if(s.getClassMode()!=null && !s.getClassMode().equals("")) {
			enq.setClassMode(s.getClassMode());
		}
		if(s.getCourseName()!=null && !s.getCourseName().equals("")) {
			enq.setCourseName(s.getCourseName());
		}
		if(s.getEnqStatus()!=null && !s.getEnqStatus().equals("")) {
			enq.setClassMode(s.getEnqStatus());
		}
		Example<StudentEnq> of = Example.of(enq);
		List<StudentEnq> enquries = srepo.findAll(of);
		return enquries;
	}

}
