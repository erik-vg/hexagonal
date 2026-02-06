package com.hexagonal.tasks.domain.ports.in;

import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;

public interface UpdateTaskUserCase {

	Optional<Task> updateTask(Long id, Task task);

}
