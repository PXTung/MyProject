package com.book.dao;

import java.util.List;

import com.book.mapper.IRowMapper;


public interface IGenericDAO<T> {
	<T> List<T> query(String sql, IRowMapper<T> rowMapper, Object...parameters);
}
