package com.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.NewsDTO;
import com.springboot.service.INewsService;

@CrossOrigin
@RestController
public class NewsAPI {
	
	@Autowired
	private INewsService newsService;
	
	@PostMapping(value = "/news")
	public NewsDTO createNew(@RequestBody NewsDTO model) {
		return newsService.save(model);
	}
	
	@PutMapping(value = "/news")
	public NewsDTO updateNew(@RequestBody NewsDTO model) {
		return newsService.save(model);
	}
	
	@DeleteMapping(value = "/news")
	public void deleteNew(@RequestBody long[] ids) {
		newsService.delete(ids);
	}
}
