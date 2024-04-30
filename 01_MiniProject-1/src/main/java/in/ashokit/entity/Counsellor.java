package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Counsellor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer cid;
private String name;
private String email;
private String pwd;
private Long phno;

}
