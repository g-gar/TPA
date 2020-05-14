package com.uem.ggar.tpa.base.model.algorithm;

public interface VoraciousAlgorithm<T,R> {

	boolean isValidSolution(R solution);
	
	T next(R elements);
	
	R execute(T element);
	R execute();
}
