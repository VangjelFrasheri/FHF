package com.firstHelpFinacial.springboot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class GNewsConfig {

	@Value("${gNewsBaseUrl}")
	private String baseUrl;
	
	@Value("${searchPath}")
	private String searchPath;
	

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getSearchPath() {
		return searchPath;
	}

	public void setSearchPath(String searchPath) {
		this.searchPath = searchPath;
	}

	
	public String getSearchUrl(String keyword, String apiKey, int max) {
		return baseUrl + searchPath + "?q="+ keyword +"&apikey="+ apiKey+ "&max="+ max;
	}

	public String getArticleByTitleUrl(String keywordsInTitle, String apiKey, int max) {
		return baseUrl + searchPath + "?q="+ keywordsInTitle +"&apikey="+ apiKey+ "&in=title&max="+ max;
	}
	
	public String getArticleByFromDate(String keywordsInTitle, String apiKey, int max, String from) {
		return baseUrl + searchPath + "?q="+ keywordsInTitle +"&apikey="+ apiKey+ "&in=title&max="+ max +"&from=" + from;
	}
	
	public String getArticleByToDate(String keywordsInTitle, String apiKey, int max, String to) {
		return baseUrl + searchPath + "?q="+ keywordsInTitle +"&apikey="+ apiKey+ "&in=title&max="+ max +"&to=" + to;
	}
	
	public String getArticleBetweenDates(String keywordsInTitle, String apiKey, int max, String from, String to) {
		return baseUrl + searchPath + "?q="+ keywordsInTitle +"&apikey="+ apiKey+ "&in=title&max="+ max +"&from=" + from +"&to=" + to;
	}
	
}
