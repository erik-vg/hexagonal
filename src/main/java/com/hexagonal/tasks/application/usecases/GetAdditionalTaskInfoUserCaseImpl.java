package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.AditionalTaskInfo;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUserCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUserCaseImpl implements GetAdditionalTaskInfoUserCase {

	private final ExternalServicePort externalServicePort;

	public GetAdditionalTaskInfoUserCaseImpl(ExternalServicePort externalServicePort) {
		this.externalServicePort = externalServicePort;
	}

	@Override
	public AditionalTaskInfo getAditionalTaskInfo(Long id) {
		return externalServicePort.getAditionalTaskInfo(id);
	}

}
