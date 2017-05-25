package com.savchuk.jsonbean;

public class AjaxMsg {
	private String message;
	private String error;
	
	public AjaxMsg() {
		
	}
	
	public AjaxMsg(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
