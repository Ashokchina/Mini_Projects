package ashokit.service;

import java.util.List;

import ashokit.entity.StudentEnq;

public interface EnquiryService {
public boolean AddEnq(StudentEnq se);

public List<StudentEnq>getEnquries(Integer cid);
}
