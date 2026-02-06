package com.hexagonal.tasks.application.usecases;

import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.UpdateTaskUserCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;

public class UpdateTaskUserCaseImpl implements UpdateTaskUserCase {

	private final TaskRepositoryPort taskRepositoryPort;

	public UpdateTaskUserCaseImpl(TaskRepositoryPort taskRepositoryProt) {
		this.taskRepositoryPort = taskRepositoryProt;
	}

	@Override
	public Optional<Task> updateTask(Long id, Task task) {
		return taskRepositoryPort.update(task);
	}

}
