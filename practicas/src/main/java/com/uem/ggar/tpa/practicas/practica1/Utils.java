package com.uem.ggar.tpa.practicas.practica1;

import java.util.function.Function;

public class Utils {

	public static Boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
	}
	
	public static <A> A time(Function<A, A> fn) {
		long a = System.nanoTime();
		A result = fn.apply(null);
		long b = System.nanoTime();
		System.out.printf("Method executed in %.2fms\n", Double.valueOf((b-a) / Double.valueOf(1000000)));
		return result;
	}
	
}
