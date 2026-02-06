package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.CreateTaskUserCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUserCaseImpl implements CreateTaskUserCase {

	private final TaskRepositoryPort taskRepositoryPort;

	public CreateTaskUserCaseImpl(TaskRepositoryPort taskRepositoryProt) {
		this.taskRepositoryPort = taskRepositoryProt;
	}

	@Override
	public Task createTask(Task task) {
		return taskRepositoryPort.save(task);
	}

}
