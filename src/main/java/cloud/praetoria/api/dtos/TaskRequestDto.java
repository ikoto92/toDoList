package cloud.praetoria.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskRequestDto {
	private String title;
	private String description;
}
