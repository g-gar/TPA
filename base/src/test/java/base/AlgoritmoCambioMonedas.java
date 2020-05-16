package base;

import java.util.Iterator;
import java.util.Stack;

import com.uem.ggar.tpa.base.model.algorithm.AbstractVoraciousAlgorithm;

public class AlgoritmoCambioMonedas extends AbstractVoraciousAlgorithm<Double, Stack<Double>>{
	
	private final Double total;

	public AlgoritmoCambioMonedas(Stack<Double> elements, Double total) {
		super(elements);
		this.total = total;
	}

	@Override
	public boolean isValidSolution(Stack<Double> solution) {
		boolean result = solution == null;
		if (!result) {
			Double temp = 0.0;
			Iterator<Double> it = solution.iterator();
			while (it.hasNext()) temp += it.next();
			result = result && !temp.equals(this.total);
		}
		return !result;
	}

	@Override
	public Double next(Stack<Double> elements) {
		return elements.pop();
	}

	@Override
	public Stack<Double> execute(Double element) {
		Stack<Double> monedas = new Stack<Double>();
		Double temp = 0.0;
		
		for (Iterator<Double> it = elements.iterator(); it.hasNext();) {
			Double moneda = it.next();
			while ((temp + moneda) < this.total) {
				temp += moneda;
				monedas.push(moneda);
			}
		}
		
		return monedas;
	}

	/**
	 * Enable multiple execution of this method by creating a snapshot of elements and then restoring it
	 */
	@Override
	public Stack<Double> execute() {
		Stack<Double> elements = new Stack<Double>() {{
			addAll(AlgoritmoCambioMonedas.this.elements);
		}};
		Stack<Double> solution = super.execute();
		this.elements.removeAllElements();
		this.elements.addAll(elements);
		return solution;
	}
}
