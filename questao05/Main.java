package questao05;
import java.util.Scanner;
import questao05.LinkedList;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// We create a new list with 8 nodes
		LinkedList lista = new LinkedList();
		for(int i = 0; i < 8; i++) {
			System.out.println("Say something: ");
			String x = in.next();
			lista.insertNode(lista, x);
			lista.printList(lista);
			System.out.println("\n");
		}
		
		System.out.println("This is the initial list: ");
		lista.printList(lista);
		System.out.println("\n");
		// Here we call the removeDuplicate method!
		lista.removeDuplicate(lista.head);
		System.out.println("After removing the duplicates this is the list now: ");
		lista.printList(lista);

		in.close();
	}
}
