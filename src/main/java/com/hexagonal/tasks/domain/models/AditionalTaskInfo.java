package com.hexagonal.tasks.domain.models;

public class AditionalTaskInfo {

	private final Long userId;

	private final String userName;

	private final String userEmail;

	public AditionalTaskInfo(Long userId, String userName, String userEmail) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

}
