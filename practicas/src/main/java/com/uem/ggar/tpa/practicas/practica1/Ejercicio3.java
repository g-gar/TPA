package com.uem.ggar.tpa.practicas.practica1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.uem.ggar.tpa.base.model.Task;

public class Ejercicio3 implements Task<Integer, Void> {
	
	private final Function<Integer, Integer> fn;
	private final Map<Integer, Integer> map;
	
	public Ejercicio3(Function<Integer,Integer> fn) {
		this(new HashMap<Integer, Integer>(), fn);
	}
	public Ejercicio3(Map<Integer, Integer> map, Function<Integer, Integer> fn) {
		this.map = map;
		this.fn = fn;
	}

	public Void execute(Integer n) {
		Integer key = this.fn.apply(n);
		System.out.printf("Putting value %s at key %s\n", n, key);
		this.map.put(key, n);
		System.out.println("____________________________________________________________");
		
		return null;
	}

}
