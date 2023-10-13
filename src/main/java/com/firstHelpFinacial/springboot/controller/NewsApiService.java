package com.firstHelpFinacial.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.firstHelpFinacial.springboot.api.GNewsApi;
import com.firstHelpFinacial.springboot.configuration.AuthConfig;
import com.firstHelpFinacial.springboot.configuration.GNewsConfig;
import com.firstHelpFinacial.springboot.model.GNewsResponse;
import com.firstHelpFinacial.springboot.util.FirstHelpFinancialUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;


@RestController
@RequestMapping("/api/v1/gNews")
public class NewsApiService {

	@Autowired
	private GNewsConfig gNewsConfig;
	
	@Autowired
	private AuthConfig authConfig;
		
	FirstHelpFinancialUtil util = new FirstHelpFinancialUtil();
	
	GNewsApi gNewsApi = new GNewsApi();
	
	private static final Logger log = LoggerFactory.getLogger(NewsApiService.class);

//	@Cacheable(cacheNames="articles", key="#searchText")
	@Cacheable("articleKeyword")
	@GetMapping("/searchArticle/keyword")
	public GNewsResponse getArticleByKeyword(@RequestParam String searchText, @RequestParam(required = false, defaultValue="5") Integer numOfArticles){
		System.out.println("making the api call");
		String url = gNewsConfig.getSearchUrl(searchText, authConfig.getAuthKey(), numOfArticles);
		return gNewsApi.getByKeyWord(url);
	}
	
	@Cacheable(cacheNames="articleKeyword")
	@GetMapping("/searchArticle/title")
	public GNewsResponse getArticleByTitle(@RequestParam String searchText, @RequestParam(required = false, defaultValue="5") Integer numOfArticles){
		System.out.println("making the api call 2");
		String url = gNewsConfig.getArticleByTitleUrl(searchText, authConfig.getAuthKey(), numOfArticles);
		return gNewsApi.getArticleByTitle(url);
	}
	
	@GetMapping("/searchArticle/source")
	public GNewsResponse getArticleByKeywordAndSource(@RequestParam String searchText, @RequestParam(required = false, defaultValue="5") Integer numOfArticles, 
			@RequestParam String source){
		String url = gNewsConfig.getSearchUrl(searchText, authConfig.getAuthKey(), numOfArticles);
		return gNewsApi.getByKeywordAndSource(source, url);
	}
	
	@GetMapping("/searchArticle/date")
	public GNewsResponse getArticleByKeywordAndDate(@RequestParam String searchText, @RequestParam(required = false, defaultValue="5") Integer numOfArticles, 
			@RequestParam(required = false) String from, @RequestParam(required = false) String to){
		String url = null;
		try {
			if(from != null && to != null) {
				from = util.dateFormatterFromDate(from);
				to = util.dateFormatterToDate(to);
				url = gNewsConfig.getArticleBetweenDates(searchText, authConfig.getAuthKey(), numOfArticles, from, to);
			}
			
			if(from != null && to == null) {
				from = util.dateFormatterFromDate(from);
				url = gNewsConfig.getArticleByFromDate(searchText, authConfig.getAuthKey(), numOfArticles, from);
				
			}
			if(from == null && to != null) {
				to = util.dateFormatterToDate(to);
				url = gNewsConfig.getArticleByToDate(searchText, authConfig.getAuthKey(), numOfArticles, to);
				
			}
			return gNewsApi.getByKeywordAndDate(from, to, url);
		
		}
		
		catch(Exception e) {
			log.error("Error in getting articles - Error: " + e);
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while calling the /searchArticle/date service"
			);
		}
	}
	
	@GetMapping("/searchArticle/today")
	public GNewsResponse getArticleFromToday(@RequestParam String searchText, @RequestParam(required = false, defaultValue="5") Integer numOfArticles){
		try {
			String startOfTomorrow = util.getTomorrowsDate();
			String startOfToday = util.getTodaysDate();
			String url = gNewsConfig.getArticleBetweenDates(searchText, authConfig.getAuthKey(), numOfArticles, startOfToday, startOfTomorrow);
			return gNewsApi.getFromToday(url);
		}
		
		catch(Exception e) {
			log.error("Error in getting articles - Error: " + e);
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while calling the /searchArticle/date service"
			);
		}
	}
	
}
