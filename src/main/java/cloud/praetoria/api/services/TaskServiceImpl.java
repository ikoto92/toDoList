package cloud.praetoria.api.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cloud.praetoria.api.dtos.TaskRequestDto;
import cloud.praetoria.api.dtos.TaskResponseDto;
import cloud.praetoria.api.mappers.TaskMapper;
import cloud.praetoria.api.models.Task;

@Service
public class TaskServiceImpl implements TaskService{
	// simule un bdd avec la map
	private Map<Long, Task> tasks = new HashMap<>();

	@Override
	public TaskResponseDto createTask(TaskRequestDto dto) {
		Task task = TaskMapper.toEntity(dto);
		// on simule la DAO en sauvegardant la tache dans la map
		tasks.put(task.getId(), task);
		return TaskMapper.toDto(task);
	}

	@Override
	public TaskResponseDto updateTask(Long id, TaskRequestDto task) {
		
		Task existingTask = tasks.get(id);
		
		if (existingTask == null) {
			return null;
		}
		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		
		tasks.put(id, existingTask);
		return TaskMapper.toDto(existingTask);	
	}

	@Override
	public boolean deleteTask(Long id) {
		
		if (tasks.containsKey(id)) {
			tasks.remove(id);
			return true;
		}
		return false;
		
	}

	@Override
	public List<TaskResponseDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskResponseDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
