package com.firstHelpFinacial.springboot.model;

public class Article {
	
	private String title;
	private String description;
	private String content;
	private String url;
	private String image;
	private String publishedAt;
	private Source source;
	

	public Article() {
		
	}
	
	
	public Article(String title, String description, String content, String url, String image, String publishedAt,
			Source source) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.url = url;
		this.image = image;
		this.publishedAt = publishedAt;
		this.source = source;
	}


	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getPublishedAt() {
		return publishedAt;
	}
	
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
	
	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}


	
}
