package base;

import java.util.Iterator;
import java.util.Stack;

import com.uem.ggar.tpa.base.model.algorithm.AbstractVoraciousAlgorithm;

public class AlgoritmoCambioMonedas extends AbstractVoraciousAlgorithm<Double, Stack<Double>>{
	
	private final Double total;

	public AlgoritmoCambioMonedas(Stack<Double> monedas, Double total) {
		super(monedas);
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
		
		for (Iterator<Double> it = this.elements.iterator(); it.hasNext();) {
			Double moneda = it.next();
			while ((temp + moneda) < this.total) {
				temp += moneda;
				monedas.push(moneda);
			}
		}
		
		return monedas;
	}

}
