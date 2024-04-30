package ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ashokit.entity.Course;

public interface CourseRepo extends JpaRepository<Course, String> {

}
