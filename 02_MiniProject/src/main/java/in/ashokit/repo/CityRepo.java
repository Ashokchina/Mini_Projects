package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {
    List<City> findBySid(Integer sid); 
}

