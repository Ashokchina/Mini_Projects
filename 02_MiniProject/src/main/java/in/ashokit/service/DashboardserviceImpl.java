package in.ashokit.service;

import java.io.IOException;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.binding.Quote;

@Service
public class DashboardserviceImpl implements DashboardService {
	Random r = new Random();
	private String quoteUrl = "https://type.fit/api/quotes";
	private Quote[] quotes = null;

	@Override
	public String getQuote() {
		String str ="";
		if (quotes == null) {
			RestTemplate rt = new RestTemplate();
			ResponseEntity<String> forEntity = rt.getForEntity(quoteUrl, String.class);
			String body = forEntity.getBody();

			ObjectMapper mapper = new ObjectMapper();
			try {
				quotes = mapper.readValue(body, Quote[].class);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else {
			int nextInt = r.nextInt(quotes.length - 1);
			  str = quotes[nextInt].getText();
		}
		
	
return str;
		
	}
}
