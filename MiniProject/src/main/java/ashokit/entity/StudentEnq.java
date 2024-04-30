package ashokit.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stu_enq_info")
public class StudentEnq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enqid;
	private String name;
	private String classMode;
	private String Course;
	private String status;
	@CreatedDate
	private LocalDate created_date;
	private Integer cid;

}
