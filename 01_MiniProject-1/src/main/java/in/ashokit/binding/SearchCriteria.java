package in.ashokit.binding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class SearchCriteria {
private String courseName;
private String enqStatus;
private String classMode;

}
