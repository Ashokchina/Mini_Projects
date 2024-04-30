package ashokit.service;

import java.util.Optional;

import ashokit.entity.Counselor;

public interface CounselorService {
Boolean saveCounselor(Counselor c);
Optional<Counselor>validate(String email);
}
