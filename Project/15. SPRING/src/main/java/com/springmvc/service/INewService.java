package com.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.springmvc.dto.NewsDTO;

public interface INewService {
	List<NewsDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewsDTO findById(long id);
	NewsDTO save(NewsDTO dto);
	void delete(long[] ids);
}
