package base;

import java.util.Iterator;
import java.util.Stack;
import java.util.function.Predicate;

import com.uem.ggar.tpa.base.model.algorithm.AbstractVoraciousAlgorithm;

public class AlgoritmoCambioMonedas extends AbstractVoraciousAlgorithm<Double, Stack<Double>>{

	@Override
	public Stack<Double> generateSolutionForElement(Stack<Double> elements, Double element, Predicate<Double> fn) {
		Stack<Double> monedas = new Stack<Double>();
		Double temp = 0.0;
		
		for (Iterator<Double> it = elements.iterator(); it.hasNext();) {
			Double moneda = it.next();
			while (fn.test(temp + moneda)) {
				temp += moneda;
				monedas.push(moneda);
			}
		}
		
		return monedas;
	}

}
