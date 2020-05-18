package com.uem.ggar.tpa.base.model.algorithm;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public abstract class AbstractVoraciousAlgorithm<T, R extends Collection<T>> implements VoraciousAlgorithm<T,R> {

	@Override
	public R execute(R elements, Predicate<T> fn) {
		R solution = null, tempSolution = null;
		Iterator<T> it = elements.iterator();
		while (it.hasNext() && solution == null) {
			if (( tempSolution = this.generateSolutionForElement(elements, it.next(), fn) ) != null) {
				solution = tempSolution;
			}
		}
		return solution;
	}
	
}
