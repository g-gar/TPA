package com.uem.ggar.tpa.practicas.practica1;

import java.util.ArrayList;
import java.util.List;

import com.uem.ggar.tpa.base.model.Task;

public class Ejercicio2<A> implements Task<List<A>, Boolean> {

	private final Integer parts;
	private A itemToSearch;

	public Ejercicio2(Integer parts) {
		this.parts = parts;
	}
	
	public Ejercicio2<A> setItemToSearch(A item) {
		this.itemToSearch = item;
		return this;
	}

	@Override
	public Boolean execute(List<A> list) {
		List<List<A>> sublists = new ArrayList<List<A>>();
		int chunk = (int) Math.ceil(Double.valueOf(list.size()) / Double.valueOf(parts));
		for (int i = 0; i < list.size(); i += chunk) {
			sublists.add(list.subList(i, Math.min(i + chunk, list.size())));
		}

		boolean result = itemToSearch != null && list.size() == 1 && list.get(0).equals(itemToSearch);
		int i = 0;
		List<A> sublist;
		while (list.size() > 1 && !result && i < sublists.size()) {
			sublist = sublists.get(i);
			result = result || execute(sublist);
			i++;
		}
		return result;
	}
	
//	@Override
//	public Integer execute(List<A> list) {
//		List<List<A>> sublists = new ArrayList<List<A>>();
//		int chunk = (int) Math.ceil(Double.valueOf(list.size()) / Double.valueOf(parts));
//		for (int i = 0; i < list.size(); i += chunk) {
//			sublists.add(list.subList(i, Math.min(i + chunk, list.size())));
//		}
//
//		boolean result = itemToSearch != null && list.size() == 1 && list.get(0).equals(itemToSearch);
//		int i = 0;
//		int position = -1;
//		while (list.size() > 1 && !result && i < sublists.size()) {
//			position = position + i * chunk + execute(sublists.get(i++));
//			result = result || position > -1;
//		}
//		return position;
//	}
	
//	@Override
//	public Integer execute(List<A> list) {
//		boolean result = itemToSearch != null && list.size() == 1 && list.get(0).equals(itemToSearch);
//		int chunk = (int) Math.ceil(Double.valueOf(list.size()) / Double.valueOf(parts));
//		int i = 0;
//		int pos = -1;
//		int temp;
//		while (!result && (i += chunk) < list.size()) {
//			List<A> a = list.subList(i, Math.min(i + chunk, list.size()));
//			temp = execute(a);
//			if (temp > -1) {
//				pos += i + temp;
//			}
//			result = result || pos > -1;
//		}
//
//		return pos;
//	}

}
