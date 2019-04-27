package questao05;

public class Node {
	String value;
	Node next;
	
	// A node has a String value and a link to the next node in the list, which is null by default.
	public Node(String value) {
		this.value = value;
		this.next = null;
	}
}
