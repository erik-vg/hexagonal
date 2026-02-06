package com.hexagonal.tasks.application.usecases;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.RetrieveTaskUserCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;

public class RetrieveTaskUserCaseImpl implements RetrieveTaskUserCase {

	private final TaskRepositoryPort taskRepositoryPort;

	public RetrieveTaskUserCaseImpl(TaskRepositoryPort taskRepositoryProt) {
		this.taskRepositoryPort = taskRepositoryProt;
	}

	@Override
	public Optional<Task> getTask(Long id) {
		return taskRepositoryPort.findById(id);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepositoryPort.findAll();
	}

}
