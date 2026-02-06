package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.ports.in.DeleteTaskUserCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUserCaseImpl implements DeleteTaskUserCase {

	private final TaskRepositoryPort taskRepositoryPort;

	public DeleteTaskUserCaseImpl(TaskRepositoryPort taskRepositoryProt) {
		this.taskRepositoryPort = taskRepositoryProt;
	}

	@Override
	public boolean deleteTask(Long id) {
		return taskRepositoryPort.deleteById(id);
	}

}
