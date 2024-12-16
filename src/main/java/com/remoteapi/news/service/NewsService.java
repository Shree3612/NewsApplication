package com.remoteapi.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    //complete remote API : https://newsapi.org/v2/top-headlines?country=us&apiKey=251dcfe49d8844eab78ccfccaae3e5bf

    String baseUrl = "https://newsapi.org/v2/top-headlines";


    public Object getNewsByCountry(String country, String apiKey) {
        String url = prepareUrl(String baseUrl, String country, String apiKey);
        Object response = restTemplate.getForObject(url, Object.class);
        return response;
    }


    public String prepareUrl(String baseUrl, String country, String apiKey) {
        String completeUrl = baseUrl+"?country="+country+"&apiKey="+apiKey;
        return completeUrl;
    }
}
