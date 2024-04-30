package in.ashokit.binding;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResetPwd {
	private Integer userId;
	private String email;
	private String newPwd;
	private String confirmpwd;

}
