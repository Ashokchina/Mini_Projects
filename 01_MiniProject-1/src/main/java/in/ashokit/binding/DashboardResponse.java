package in.ashokit.binding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DashboardResponse {
private Integer totalEnq;
private Integer enrolledEnq;
private Integer lostEnq;
}
