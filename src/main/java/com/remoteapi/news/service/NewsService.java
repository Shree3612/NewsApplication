package com.remoteapi.news.service;

import com.remoteapi.news.dto.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    //complete remote API : https://newsapi.org/v2/top-headlines?country=us&apiKey=251dcfe49d8844eab78ccfccaae3e5bf

    //URl tht needs to be searched : "http://localhost:8080/api/v1/news/country?country=us&apiKey=251dcfe49d8844eab78ccfccaae3e5bf"
    String baseUrl = "https://newsapi.org/v2/top-headlines";


    public NewsResponse getNewsByCountry(String country, String apiKey) {
        String url = prepareUrl( baseUrl,  country,  apiKey);
        return restTemplate.getForObject(url, NewsResponse.class);
    }


    public String prepareUrl(String baseUrl, String country, String apiKey) {
        String completeUrl = baseUrl+"?country="+country+"&apiKey="+apiKey;
        return completeUrl;
    }
}
