package com.example.demorestjdbc.entity;

public class ResultBoolean {

	private Boolean result;

	public ResultBoolean() {
		super();
	}

	public ResultBoolean(Boolean result) {
		super();
		this.result = result;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResultBoolean [result=" + result + "]";
	}
	
}
