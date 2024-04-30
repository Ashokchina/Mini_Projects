package ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ashokit.entity.Student;

public interface StudentRepo extends JpaRepository<Student, String> {

}
