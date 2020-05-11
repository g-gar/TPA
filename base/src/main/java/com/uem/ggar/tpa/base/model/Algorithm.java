package com.uem.ggar.tpa.base.model;

public interface Algorithm<T, R> {
	R execute(T param);
}
