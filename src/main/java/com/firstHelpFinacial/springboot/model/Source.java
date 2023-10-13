package com.firstHelpFinacial.springboot.model;

public class Source {

	private String name;
	private String url;
	
	public Source(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	public Source() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
