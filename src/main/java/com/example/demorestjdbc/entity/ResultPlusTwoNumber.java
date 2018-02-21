package com.example.demorestjdbc.entity;

public class ResultPlusTwoNumber {

	private Double result;

	public ResultPlusTwoNumber() {
		super();
	}

	public ResultPlusTwoNumber(Double result) {
		super();
		this.result = result;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResultPlusTwoNumber [result=" + result + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultPlusTwoNumber other = (ResultPlusTwoNumber) obj;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}
	
}
