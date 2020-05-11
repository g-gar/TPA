package com.uem.ggar.tpa.practicas.practica1;

public class Traspuesta {

	public static boolean esTraspuesta_v1(int[][] a, int[][] b) {
		boolean traspuesta = true;
		for (int fila = 0; fila < a.length; fila++) {
			for (int col = 0; col < a[fila].length; col++) {
				if (a[fila][col] != b[col][fila]) {
					traspuesta = false;
				}
			}
		}
		return traspuesta;
	}

	public static boolean esTraspuesta_v2(int[][] a, int[][] b) {
		boolean traspuesta = a != null && b != null && a[0] != null && b[0] != null && a[0].length == b[0].length;
		int fila = 0;
		int columna;
		while (traspuesta && fila < a.length) {
			columna = 0;
			while (traspuesta && columna < a.length) {
				if (a[fila][columna] != b[columna][fila]) {
					traspuesta = false;
				}
			}
		}
		return traspuesta;
	}

	public static boolean esTraspuesta_DyV(int[][] a, int[][] b) {
		boolean traspuesta = a != null && b != null && a[0] != null && b[0] != null && a.length == b.length
				&& a[0].length == b[0].length;
		int[][] _a;
		int[][] _b;
		int size;
		int contador;
		if (traspuesta && a.length == 1 && a[0].length == 1 && b.length == 1 && b[0].length == 1) {
			traspuesta &= a[0][0] == b[0][0];
		} else {
			contador = 0;
			while (traspuesta && contador < a[0].length) {
				traspuesta &= a[0][contador] == b[contador][0];
				contador++;
			}
			if (traspuesta) {
				size = a.length - 1;
				_a = new int[size][size];
				_b = new int[size][size];
				for (int fila = 1; fila < size + 1; fila++) {
					for (int columna = 1; columna < size + 1; columna++) {
						_a[fila - 1][columna - 1] = a[fila][columna];
						_b[fila - 1][columna - 1] = b[fila][columna];
					}
				}
				traspuesta &= esTraspuesta_DyV(_a, _b);
			}
		}
		return traspuesta;
	}

	public static void main(String[] args) {

		int[][] m1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		int[][] m2 = { { 1, 5, 1, 5 }, { 2, 6, 2, 6 }, { 3, 7, 3, 7 }, { 4, 8, 4, 8 } };

		int[][] m3 = { { 0, 5, 1, 5 }, { 2, 6, 2, 6 }, { 3, 7, 3, 7 }, { 4, 8, 4, 8 } };

		System.out.println("PRUEBA 1:");
		System.out.println(" * esTraspuesta_v1 (m1, m2): " + Utils.time(e -> esTraspuesta_v1(m1, m2)));
		System.out.println(" * esTraspuesta_v1 (m1, m3): " + Utils.time(e -> esTraspuesta_v1(m1, m3)));

		System.out.println("\nPRUEBA 2:");
		System.out.println(" * esTraspuesta_v2 (m1, m2): " + Utils.time(e -> esTraspuesta_v1(m1, m2)));
		System.out.println(" * esTraspuesta_v2 (m1, m3): " + Utils.time(e -> esTraspuesta_v1(m1, m3)));

		System.out.println("\nPRUEBA 3:");
		System.out.println(" * esTraspuesta_DyV (m1, m2): " + Utils.time(e -> esTraspuesta_DyV(m1, m2)));
		System.out.println(" * esTraspuesta_DyV (m1, m3): " + Utils.time(e -> esTraspuesta_DyV(m1, m3)));

		/* ****** DATOS PERSONALES ****** */

		String miNombre = "Gabriel";
		String misApellidos = "Garc�a Fern�ndez";
		String miExpediente = "21863752";

		System.out.println("\nESTUDIANTE:");
		System.out.println(" * Apellidos:\t" + misApellidos);
		System.out.println(" * Nombre:\t" + miNombre);
		System.out.println(" * Expediente:\t" + miExpediente);

		System.out.println("\n*** FIN ***");

	}// main

}
