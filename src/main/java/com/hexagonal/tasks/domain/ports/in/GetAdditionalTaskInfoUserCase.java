package com.hexagonal.tasks.domain.ports.in;

import com.hexagonal.tasks.domain.models.AditionalTaskInfo;

public interface GetAdditionalTaskInfoUserCase {

	AditionalTaskInfo getAditionalTaskInfo(Long id);

}
