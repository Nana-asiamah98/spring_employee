package com.test.app.employer.dto;

import org.springframework.stereotype.Component;

@Component
public class ResponseDTO {
	private boolean actionState;
	
	public boolean isActionState() {
		return actionState;
	}

	public void setActionState(boolean actionState) {
		this.actionState = actionState;
	}

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	private String actionMessage;
}
