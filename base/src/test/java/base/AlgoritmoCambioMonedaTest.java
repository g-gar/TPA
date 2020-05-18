package base;

import java.util.ArrayList;
import java.util.Stack;

public class AlgoritmoCambioMonedaTest {

	public static void main(String[] args) {

		Stack<Double> monedas = new Stack<Double>();
		monedas.addAll(new ArrayList<Double>() {
			{
				add(2.0);
				add(1.0);
				add(0.5);
				add(0.2);
				add(0.1);
				add(0.05);
				add(0.02);
				add(0.01);
			}
		});
		AlgoritmoCambioMonedas alg = new AlgoritmoCambioMonedas();
		System.out.println(alg.execute(monedas, e -> e < 5.89));
		System.out.println(alg.execute(monedas, e -> e < 5.88));
	}

}
