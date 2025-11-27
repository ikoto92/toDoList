package cloud.praetoria.api.mappers;

import cloud.praetoria.api.dtos.TaskRequestDto;
import cloud.praetoria.api.dtos.TaskResponseDto;
import cloud.praetoria.api.models.Task;

public class TaskMapper {
	private static Long counter = 0L;
	
	public static Task toEntity(TaskRequestDto dto) {
		return Task.builder()
				.id(++counter)
				.title(dto.getTitle())
				.description(dto.getDescription())
				.completed(false)
				.build();
	}
	
	public static TaskResponseDto toDto(Task task) {
		return TaskResponseDto.builder()
				.id(task.getId())
				.title(task.getTitle())
				.description(task.getDescription())
				.completed(task.isCompleted())
				.build();
	}

}
