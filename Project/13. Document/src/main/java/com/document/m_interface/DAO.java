package com.document.m_interface;

import java.util.List;

public interface DAO<T> {
	void add(T t);
	List<T> show();
}
