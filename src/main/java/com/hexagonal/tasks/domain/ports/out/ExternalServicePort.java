package com.hexagonal.tasks.domain.ports.out;

import com.hexagonal.tasks.domain.models.AditionalTaskInfo;

public interface ExternalServicePort {
	
	AditionalTaskInfo getAditionalTaskInfo(Long taskId);

}
