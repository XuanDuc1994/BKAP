package com.bkap.web.entity;

import java.sql.ResultSet;

public abstract class IEntity<T> {
	public abstract T toEntity(ResultSet rs) throws Exception;
}
