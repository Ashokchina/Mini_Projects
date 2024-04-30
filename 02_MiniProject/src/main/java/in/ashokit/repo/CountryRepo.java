package in.ashokit.repo;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Country;
import java.util.List;


public interface CountryRepo extends JpaRepository<Country, Integer> {

}
