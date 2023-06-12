package Ejercicio2;

public class WorstCase {
	
	public static void main(String[]args) {
		
		DoubleList<Integer> lista = worstCase(10);
		lista.print();
		lista.insertionSort();
		lista.print();
		
	}
	
    // Función para crear el peor caso 
	public static DoubleList<Integer> worstCase(int n) {
		DoubleList<Integer> lista = new DoubleList<Integer>();
		for(; n>0; n--)
			lista.add(n);
		return lista;
	}
	
}
