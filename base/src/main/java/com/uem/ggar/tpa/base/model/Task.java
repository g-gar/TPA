package com.uem.ggar.tpa.base.model;

public interface Task<E,T> {

	T execute(E params);
	
}
