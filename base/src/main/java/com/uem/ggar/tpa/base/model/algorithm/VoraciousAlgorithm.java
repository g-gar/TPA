package com.uem.ggar.tpa.base.model.algorithm;

import java.util.function.Predicate;

public interface VoraciousAlgorithm<T,R> {
	
	R generateSolutionForElement(R elements, T element, Predicate<T> checkFunction);
	
	R execute(R elements, Predicate<T> checkFunction);
	
}
