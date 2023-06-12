package Ejercicio2;

// Clase para crear listas doble enlazadas
public class DoubleList<T extends Comparable<T>> {

	private Node<T> root;
	private int size;
	
	public DoubleList() {
		root = null; 
		size = 0;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void add(T data) {
		if(isEmpty()) { 
			root = new Node<T>(data, null, null);
			size++;
		}
		else {
			Node<T> aux = root;
			while(aux.getNext() != null)
				aux = aux.getNext();
			aux.setNext(new Node<T>(data, null, aux));
			size++;
		}
	}
	
	public Node<T> get(int indice) {
		Node<T> aux = root;
		for(int i=0; i<indice; i++) {
			aux = aux.getNext();
		}
		return aux;
	}
	
	public T remove(int i) {
		if(i==0) {
			T data = root.getData();
			root = root.getNext();
			size--;
			return data;
		}
		else if(i<size && i>0) {
			Node<T> aux = root;
			i--;
			while(i!=0) {
				aux = aux.getNext();
				i--;
			}
			T data = aux.getNext().getData();
			aux.setNext(aux.getNext().getNext());
			size--;
			return data;
		} else
			return null;
	}
	
    // Función para ordenar mediante el ordenamiento por inserción una lista doble enlazada
	public void insertionSort() {
		for(int i=0; i<size; i++) {
			Node<T> aux = this.get(i);
			T key = aux.getData();
			while(aux.getPrevious()!=null && aux.getPrevious().getData().compareTo(key)>0) {
				aux.setData(aux.getPrevious().getData());
				aux = aux.getPrevious();
			}
			aux.setData(key);
		}
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("La lista esta vacia");
		} else {
			Node<T> aux = root;
			for(int i=0; i<size; i++) {
				System.out.print(aux.getData() + " ");
				aux = aux.getNext();
			}
			System.out.println("");
		}
	}
	
}
