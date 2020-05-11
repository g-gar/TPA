package com.uem.ggar.tpa.practicas.practica1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.uem.ggar.tpa.base.model.Task;
import com.uem.ggar.tpa.base.model.TernaryFunction;

public class Practica1Test {

	public void ejercicio2Test() {
		int parts;
		Boolean result;
		List<Integer> list = Arrays.asList(new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12});
//		List<Integer> list = IntStream.rangeClosed(1, 10000000).boxed().collect(Collectors.toList()).stream()
//				.map(e -> new Random().nextInt(300)).collect(Collectors.toList());
//		list.sort(Comparator.naturalOrder());
		
		parts = 2;
		Ejercicio2<Integer> ejercicio = new Ejercicio2<Integer>(parts);
		ejercicio.setItemToSearch(list.get(list.size()-1));
		result = Utils.time(e -> ejercicio.execute(list));
		System.out.printf("%s parts: %s\n", parts, result);
		
		parts = 4;
		Ejercicio2<Integer> ejercicio2 = new Ejercicio2<Integer>(parts);
		ejercicio2.setItemToSearch(list.get(list.size()-1));
		result = Utils.time(e -> ejercicio2.execute(list));
		System.out.printf("%s parts: %s\n", parts, result);
		
//		parts = 8;
//		Ejercicio2<Integer> ejercicio3 = new Ejercicio2<Integer>(parts);
//		ejercicio3.setItemToSearch(list.get(list.size()-1));
//		result = Utils.time(e -> ejercicio3.execute(list));
//		System.out.printf("%s parts: %s\n", parts, result);
//		
//		parts = 32;
//		Ejercicio2<Integer> ejercicio4 = new Ejercicio2<Integer>(parts);
//		ejercicio4.setItemToSearch(list.get(list.size()-1));
//		result = Utils.time(e -> ejercicio4.execute(list));
//		System.out.printf("%s parts: %s\n", parts, result);
//		
//		parts = 512;
//		Ejercicio2<Integer> ejercicio5 = new Ejercicio2<Integer>(parts);
//		ejercicio5.setItemToSearch(list.get(list.size()-1));
//		result = Utils.time(e -> ejercicio5.execute(list));
//		System.out.printf("%s parts: %s\n", parts, result);
	}
	
	public void ejercicio3Test1() {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
			{
				IntStream.rangeClosed(0, 6).forEach(i -> put(i, null));
				put(2, 9);
				put(5, 2);
			}
		};
		TernaryFunction<Integer, Integer, Integer, Integer> computeKeyFunction = (k, c, N) -> (k % N) + (c * (5 - k % 3));
		Task<Integer, Void> ejercicio = new Ejercicio3(map, new HashFunction(map, 0.8, computeKeyFunction));

		Arrays.asList(new Integer[] { 23, 6, 22, 79, 28 }).forEach(k -> ejercicio.execute(k));

		System.out.println(map);
	}

	public void ejercicio3Test2() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
			{
				IntStream.rangeClosed(0, 12).forEach(i -> put(i, null));
				put(4, 30);
				put(5, 44);
				put(6, 19);
				put(7, 20);
				put(9, 22);
				put(12, 12);
			}
		};
		TernaryFunction<Integer, Integer, Integer, Integer> computeKeyFunction = (k, c, N) -> (k % N) + (c * (5 - k % 3));
		Task<Integer, Void> ejercicio = new Ejercicio3(map, new HashFunction(map, 0.7, computeKeyFunction));

		Arrays.asList(new Integer[] { 7, 3, 31, 1 }).forEach(k -> ejercicio.execute(k));

		System.out.println(map);
	}

	public static void main(String[] args) {
		new Practica1Test().ejercicio2Test();
		//new Practica1Test().ejercicio3Test1();
		//new Practica1Test().ejercicio3Test2();
	}
	
}
