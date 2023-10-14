package com.firstHelpFinacial.springboot.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.firstHelpFinacial.springboot.model.GNewsResponse;


public class GNewsApi {

	
	private RestTemplate restTemplate = new RestTemplate();

	
	private static final Logger log = LoggerFactory.getLogger(GNewsApi.class);

	
	
	public GNewsResponse getByKeywordAndSource(String source, String url){
		GNewsResponse responseBody = getArticles(url);
		responseBody.getArticlesFromSource(source); //filters out all articles that aren't from the source passed
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
}


