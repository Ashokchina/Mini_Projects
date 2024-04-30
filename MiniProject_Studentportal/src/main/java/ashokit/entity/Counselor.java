package ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Counselor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private String cid;
private String email;
private String password;
private String phno;

}
