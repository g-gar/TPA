package com.uem.ggar.tpa.base.model;

public interface TernaryFunction<A,B,C,R> {

	R apply(A param1, B param2, C param3);
	
}
