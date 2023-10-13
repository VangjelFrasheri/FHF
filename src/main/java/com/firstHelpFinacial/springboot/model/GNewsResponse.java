package com.firstHelpFinacial.springboot.model;

import java.util.List;

public class GNewsResponse {

	private Integer totalArticles;
	private List<Article> articles;
	
	public GNewsResponse() {
		
	}
	
	public GNewsResponse(Integer totalArticles, List<Article> articles) {
		super();
		this.totalArticles = totalArticles;
		this.articles = articles;
	}
	
	

	public Integer getTotalArticles() {
		return totalArticles;
	}

	public void setTotalArticles(Integer totalArticles) {
		this.totalArticles = totalArticles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public void getArticlesFromSource(String source) {
		for(int index = 0; index < this.articles.size(); index ++) {
			if(!this.articles.get(index).getSource().getName().toLowerCase().equals(source.toLowerCase())) {
				this.articles.remove(index);
			}
		}
	}	
	
}
