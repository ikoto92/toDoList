package cloud.praetoria.api.services;

import java.util.List;

import cloud.praetoria.api.dtos.TaskRequestDto;
import cloud.praetoria.api.dtos.TaskResponseDto;

public interface TaskService {
	TaskResponseDto createTask(TaskRequestDto task);
	TaskResponseDto updateTask(Long id, TaskRequestDto task);
	boolean deleteTask(Long id);
	List<TaskResponseDto> getAll();
	TaskResponseDto getById(Long id);
}
