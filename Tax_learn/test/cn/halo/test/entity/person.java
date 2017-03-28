package cn.halo.test.entity;

import java.io.Serializable;

public class person implements Serializable {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public person() {
	}
	public person(String name) {
		this.name = name;
	}
	
}
