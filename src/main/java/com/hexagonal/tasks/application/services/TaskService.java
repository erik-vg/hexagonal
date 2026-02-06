package com.hexagonal.tasks.application.services;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.AditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.CreateTaskUserCase;
import com.hexagonal.tasks.domain.ports.in.DeleteTaskUserCase;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUserCase;
import com.hexagonal.tasks.domain.ports.in.RetrieveTaskUserCase;
import com.hexagonal.tasks.domain.ports.in.UpdateTaskUserCase;

public class TaskService implements CreateTaskUserCase, RetrieveTaskUserCase, UpdateTaskUserCase, DeleteTaskUserCase,
		GetAdditionalTaskInfoUserCase {

	public TaskService(CreateTaskUserCase createTaskUserCase, RetrieveTaskUserCase retrieveTaskUserCase,
			UpdateTaskUserCase updateTaskUserCase, DeleteTaskUserCase deleteTaskUserCase,
			GetAdditionalTaskInfoUserCase getAdditionalTaskInfoUserCase) {
		this.createTaskUserCase = createTaskUserCase;
		this.retrieveTaskUserCase = retrieveTaskUserCase;
		this.updateTaskUserCase = updateTaskUserCase;
		this.deleteTaskUserCase = deleteTaskUserCase;
		this.getAdditionalTaskInfoUserCase = getAdditionalTaskInfoUserCase;
	}

	private CreateTaskUserCase createTaskUserCase;

	private RetrieveTaskUserCase retrieveTaskUserCase;

	private UpdateTaskUserCase updateTaskUserCase;

	private DeleteTaskUserCase deleteTaskUserCase;

	private GetAdditionalTaskInfoUserCase getAdditionalTaskInfoUserCase;

	@Override
	public AditionalTaskInfo getAditionalTaskInfo(Long id) {
		return getAdditionalTaskInfoUserCase.getAditionalTaskInfo(id);
	}

	@Override
	public boolean deleteTask(Long id) {
		return deleteTaskUserCase.deleteTask(id);
	}

	@Override
	public Optional<Task> updateTask(Long id, Task task) {
		return updateTaskUserCase.updateTask(id, task);
	}

	@Override
	public Optional<Task> getTask(Long id) {
		return retrieveTaskUserCase.getTask(id);
	}

	@Override
	public List<Task> getAllTasks() {
		return retrieveTaskUserCase.getAllTasks();
	}

	@Override
	public Task createTask(Task task) {
		return createTaskUserCase.createTask(task);
	}

}
