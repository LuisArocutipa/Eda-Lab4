package Ejercicio1;

public class List<T extends Comparable<T>> {

	private Node<T> root;
	private int size;
	
	public List() {
		root = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void add(T data) {
		if(isEmpty()) { 
			root = new Node<T>(data, null);
			size++;
		}
		else {
			Node<T> aux = root;
			while(aux.getNext() != null)
				aux = aux.getNext();
			aux.setNext(new Node<T>(data, null));
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
	
    // Función que ordena la lista mediante el ordenamiento por inserción
	public void insertionSort() {
		for(int i=1; i<size; i++) {
			T key = this.get(i).getData();
			int j = i - 1;
			while(j>=0 && this.get(j).getData().compareTo(key)>0) {
				this.get(j+1).setData(this.get(j).getData());
				j--;
			}
			this.get(j+1).setData(key);
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
