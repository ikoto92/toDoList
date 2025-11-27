package cloud.praetoria.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.praetoria.api.dtos.TaskRequestDto;
import cloud.praetoria.api.dtos.TaskResponseDto;
import cloud.praetoria.api.services.TaskService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;
	
	@GetMapping("/health")
	public String taskControllerHealth() {
		return "UP";
	}

	@PostMapping("/create")
	public TaskResponseDto createTask(@RequestBody TaskRequestDto request) {
		return taskService.createTask(request);
	}
	
	@PostMapping("/update")
	public TaskResponseDto updateTask(Long id, @RequestBody TaskRequestDto request) {
		return taskService.updateTask(id, request);
	}
	
	@PostMapping("/delete")
	public boolean deleteTask(Long id) {
		return taskService.deleteTask(id);
	}
	
	@GetMapping("/all")
	public Object getAllTasks() {
		return taskService.getAll();
	}
	@GetMapping("/get")
	public TaskResponseDto getTaskById(Long id) {
		return taskService.getById(id);
	}
}
