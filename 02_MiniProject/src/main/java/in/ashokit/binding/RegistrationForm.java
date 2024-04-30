package in.ashokit.binding;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
	@Id

	private Integer uid;
	private String uname;
	private String email;
	private String pwd;
	private Integer countryid;
	private Integer stateid;
	private Integer cityid;
	@CreationTimestamp
	private LocalDate createddate;
	@UpdateTimestamp
	private LocalDate updateddate;
	private String pwdUpdated;

}
