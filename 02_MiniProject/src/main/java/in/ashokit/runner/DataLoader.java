package in.ashokit.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.entity.State;
import in.ashokit.repo.CityRepo;
import in.ashokit.repo.CountryRepo;
import in.ashokit.repo.StateRepo;

@Component
public class DataLoader  implements ApplicationRunner{
	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private StateRepo  stateRepo;
	@Autowired
	private CityRepo cityRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		countryRepo.deleteAll();
		stateRepo.deleteAll();
		cityRepo.deleteAll();
		
		Country c1 = new Country(1, "INDIA");
		Country c2 = new Country(2, "USA");
		countryRepo.saveAll(Arrays.asList(c1,c2));
		
		State s1 = new State(3, "TG", 1);
		State s2 = new State(4, "AP", 1);
		
		State s3 = new State(1, "CALIFORNIA", 2);
		State s4 = new State(2, "TEXAS", 2);
		stateRepo.saveAll(Arrays.asList(s1,s2,s3,s4));
	
	City C1 = new City(1,"HYD",3);
	City C2 = new City(2,"WARAGAL",3);
	City C3 = new City(3,"VIZAG",4);
	City C4 = new City(4,"GUNTUR",4);
	City C5 = new City(5,"CAL-1",1);
	City C6 = new City(6,"CAL-2",1);
	City C7 = new City(7,"TEX-1",2);
	City C8 = new City(8,"TEX-2",2);
	cityRepo.saveAll(Arrays.asList(C1,C2,C3,C4,C5,C6,C7,C8));
	}

}
