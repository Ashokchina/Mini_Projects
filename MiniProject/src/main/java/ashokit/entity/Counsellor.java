package ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Counsellors_info")
@AllArgsConstructor
@NoArgsConstructor
public class Counsellor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
private String name;
private String email;
private String pwd;
private String phno;
}
