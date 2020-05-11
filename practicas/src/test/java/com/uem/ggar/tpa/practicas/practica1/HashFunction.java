package com.uem.ggar.tpa.practicas.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.uem.ggar.tpa.base.model.TernaryFunction;

public class HashFunction implements Function<Integer, Integer> {

	private final Map<Integer, Integer> hashTable;
	private final Double loadFactor;
	private final TernaryFunction<Integer, Integer, Integer, Integer> computeKeyFunction;

	public HashFunction(Map<Integer, Integer> hashTable, Double loadFactor, TernaryFunction<Integer, Integer, Integer, Integer> computeKeyFunction) {
		this.hashTable = hashTable;
		this.loadFactor = loadFactor;
		this.computeKeyFunction = computeKeyFunction;
	}

	@Override
	public Integer apply(Integer k) {
		System.out.printf("k: %s\n", k);

		if (isOverloaded()) {
			System.out.printf("Table overloaded: Adding new slots...\n");
			this.augmentTable();
		}
		return computeKey(k);
	}
	
	private Integer computeKey(Integer k) {
		Integer N = hashTable.size();
		Integer c = 0;
		Integer key;
		while (hashTable.get( ( key = this.computeKeyFunction.apply(k, c, N) % N )) != null) {
			System.out.printf("Collision at k=%s with key %s\n", k, key);
			c++;
			key = this.computeKeyFunction.apply(N, c, k) % N;
		}
		return key;
	}
	
	public boolean isOverloaded() {
		double current = this.hashTable.values().stream().filter(e -> e!=null).count() + 1;
		double total = this.hashTable.size();
		return current / total > this.loadFactor;
	}
	
	public void augmentTable() {
		List<Integer> values = new ArrayList<Integer>(hashTable.values()).stream().filter(e -> e!=null).collect(Collectors.toList());
		int initial = hashTable.keySet().size() * 2;
		int i = 0;
		while (i <= initial || (initial < i && !Utils.isPrime(i))) {
			hashTable.put(i, null);
			i++;
		}
		
		System.out.printf("Updated table size to: %s\n", hashTable.keySet().size());
		
		System.out.printf("Recomputing keys...\n");
		Integer newKey;
		for (Integer j : values) {
			newKey = this.apply(j);
			System.out.printf("k: %s -> newKey: %s\n", j, newKey);
			this.hashTable.put(newKey, j);
		}
	}
	
	public Map<Integer, Integer> getHashTable() {
		return hashTable;
	}

}
