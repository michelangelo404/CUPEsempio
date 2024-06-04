package com.example.demo.model;

public class Responso<T> {

	private String status;
	private T data;

	public Responso() {

	}

	public Responso(String status, T data) {
		super();
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Responso [status=" + status + ", data=" + data + "]";
	}

}
