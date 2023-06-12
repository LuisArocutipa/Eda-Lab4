package Ejercicio1;

public class WorstCase {
	
	public static void main(String[]args) {
		
		List<Integer> lista = worstCase(10);
		lista.print();
        // Se llama a la función de la lista que la ordena mediante el ordenamiento por inserción
		lista.insertionSort();
		lista.print();
		
	}
	
    // Función que crea el peor caso posible
	public static List<Integer> worstCase(int n) {
		List<Integer> lista = new List<Integer>();
		for(; n>0; n--)
			lista.add(n);
		return lista;
	}
	
}
