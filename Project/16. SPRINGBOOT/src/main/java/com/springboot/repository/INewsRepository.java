package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.NewsEntity;

public interface INewsRepository extends JpaRepository<NewsEntity, Long>{
//	Long la kieu du lieu cua khoa chinh
	

}
