package com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.entity.NewsEntity;

public interface INewsRepository extends JpaRepository<NewsEntity, Long> {

}
