package com.springmvc.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dto.NewsDTO;
import com.springmvc.service.INewService;

@RestController(value = "newsApiOfAdmin")
public class NewsAPI {
	
	@Autowired
	private INewService newsService;
	
	@PostMapping("api/admin/news")
	public NewsDTO createNews(@RequestBody NewsDTO newsDTO) {
		return newsService.save(newsDTO);
	}
	
	@PutMapping("api/admin/news")
	public NewsDTO updateNews(@RequestBody NewsDTO newsDTO) {
		return newsService.save(newsDTO);
	}
	
	@DeleteMapping("api/admin/news")
	public void deleteNews(@RequestBody long[] ids) {
		newsService.delete(ids);
	}
}
