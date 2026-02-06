package com.hexagonal.tasks.infrastructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.domain.models.AditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		Task createTask = taskService.createTask(task);

		return new ResponseEntity<>(createTask, HttpStatus.CREATED);
	}

	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
		return taskService.getTask(taskId).map(task -> new ResponseEntity<>(task, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Task>> getAllTasks() {
		List<Task> tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

	@PutMapping("/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updateTask) {
		return taskService.updateTask(taskId, updateTask).map(task -> new ResponseEntity<>(task, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{taskId}")
	public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId) {
		if (taskService.deleteTask(taskId)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{taskId}/aditionalInfo")
	public ResponseEntity<AditionalTaskInfo> getAditionalTaskInfo(@PathVariable Long taskId) {
		AditionalTaskInfo aditionalTaskInfo = taskService.getAditionalTaskInfo(taskId);
		return new ResponseEntity<>(aditionalTaskInfo, HttpStatus.OK);
	}

}
