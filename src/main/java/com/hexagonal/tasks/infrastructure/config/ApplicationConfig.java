package com.hexagonal.tasks.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecases.CreateTaskUserCaseImpl;
import com.hexagonal.tasks.application.usecases.DeleteTaskUserCaseImpl;
import com.hexagonal.tasks.application.usecases.GetAdditionalTaskInfoUserCaseImpl;
import com.hexagonal.tasks.application.usecases.RetrieveTaskUserCaseImpl;
import com.hexagonal.tasks.application.usecases.UpdateTaskUserCaseImpl;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUserCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;

@Configuration
public class ApplicationConfig {

	@Bean
	TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUserCase getAdditionalTaskInfoUserCase) {
		return new TaskService(
				new CreateTaskUserCaseImpl(taskRepositoryPort),
				new RetrieveTaskUserCaseImpl(taskRepositoryPort), 
				new UpdateTaskUserCaseImpl(taskRepositoryPort), 
				new DeleteTaskUserCaseImpl(taskRepositoryPort), 
				getAdditionalTaskInfoUserCase);
	}
	
	@Bean
	TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
		return jpaTaskRepositoryAdapter;
	}
	
	@Bean
	GetAdditionalTaskInfoUserCase getAdditionalTaskInfoUserCase(ExternalServicePort externalServicePort) {
		return new GetAdditionalTaskInfoUserCaseImpl(externalServicePort);
	}
	
	@Bean
	ExternalServicePort externalServicePort() {
		return new ExternalServiceAdapter();
	}

}
