package com.remoteapi.news.controller;

import com.remoteapi.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

        @Autowired
        NewsService newsService;

        @GetMapping("/country")
        public Object getNewsByCountry(@RequestParam("country") String country, @RequestParam("apiKey") String apiKey) {
                return newsService.getNewsByCountry(country, apiKey);
        }
}

