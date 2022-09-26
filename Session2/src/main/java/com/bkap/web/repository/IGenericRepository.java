package com.bkap.web.repository;

import java.util.List;

import com.bkap.web.entity.IEntity;

public interface IGenericRepository<T extends IEntity<T>, ID> {
	List<T> getAll();
	T findId(ID id);
	T add(T entity);
	T edit(T entity);
	boolean remove(ID id);
}
