package com.uem.ggar.tpa.base.model.algorithm;

import java.util.Collection;

public abstract class AbstractVoraciousAlgorithm<T, R extends Collection<T>> implements VoraciousAlgorithm<T,R> {
	
	protected final R elements;
	
	public AbstractVoraciousAlgorithm(R elements) {
		this.elements = elements;
	}

	@Override
	public R execute() {
		R solution = null, tempSolution = null;
		T currentElement = null;

		while (!elements.isEmpty() && !this.isValidSolution(solution) && ( currentElement = this.next(elements) ) != null) {
			
			if (this.isValidSolution( (tempSolution = this.execute(currentElement)) )) {
				solution = tempSolution;
 			}
			
		}
		
		return solution;
	}
	
}
