package com.firstHelpFinacial.springboot.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.firstHelpFinacial.springboot.model.GNewsResponse;


public class GNewsApi {

	
	private RestTemplate restTemplate = new RestTemplate();

	
	private static final Logger log = LoggerFactory.getLogger(GNewsApi.class);

	
	public GNewsResponse getByKeyWord(String url) {
		return getArticles(url);
	}
	
	public GNewsResponse getArticleByTitle(String url){
		return getArticles(url);
	}
	
	
	public GNewsResponse getByKeywordAndSource(String source, String url){
		GNewsResponse responseBody = getArticles(url);
		responseBody.getArticlesFromSource(source);
		return responseBody;
		
		}

	
	public GNewsResponse getByKeywordAndDate(String from, String to, String url){
		GNewsResponse responseBody = new GNewsResponse();
		
		try {
			if(!(from == null && to == null)) {
				return getArticles(url);
			}
			
			log.info("There were no dates passed, returning an empty object");
			return responseBody;
		
		}
		
		catch(Exception e) {
			log.error("Error in getting articles - Error: " + e);
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while calling the /searchArticle/date service"
			);
		}
	}
	
	public GNewsResponse getFromToday(String url){
		GNewsResponse responseBody = new GNewsResponse();
		try {
			ResponseEntity<GNewsResponse> response = restTemplate.exchange(
					url,
					HttpMethod.GET,
					null,
					GNewsResponse.class
				);
			responseBody = response.getBody();
			return responseBody;
		}
		
		catch(Exception e) {
			log.error("Error in getting articles - Error: " + e);
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while calling the /searchArticle/date service"
			);
		}
	}
	
	public GNewsResponse getArticles(String url) {
		GNewsResponse responseBody = new GNewsResponse();
		try {
			ResponseEntity<GNewsResponse> response = restTemplate.exchange(
					url,
					HttpMethod.GET,
					null,
					GNewsResponse.class
				);
			responseBody = response.getBody();
			return responseBody;
		}
		
		catch(Exception e) {
			log.error("Error in getting articles - Error: " + e);
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while calling " + url
			);
		}
	}

//	@Override
//	public void customize(ConcurrentMapCacheManager cacheManager) {
//		cacheManager.setCacheNames(Arrays.asList("gNewsResponse"));
//		
//	}
}


