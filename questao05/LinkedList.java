package questao05;
import questao05.Node;

public class LinkedList {
	
	Node head;
	
	public void insertNode(LinkedList list, String value) {
		Node newNode = new Node(value);
		if(list.head == null) {
			list.head = newNode;
		} else {
			Node currentNode = list.head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
				}
				currentNode.next = newNode;	
		}
	}
	
	public void printList(LinkedList list) {
		Node currentNode = list.head;
		while(currentNode != null) {
			System.out.print(currentNode.value);
			currentNode = currentNode.next;
		}
	}
	
	public void removeDuplicate(Node head) {
		Node currentNode = head;
		Node nextNode = currentNode.next;
		Node prevNode = currentNode;
		while(currentNode != null) {
			while (nextNode != null) {
				if (currentNode.value.equals(nextNode.value)) {
					prevNode.next = nextNode.next;
					nextNode = nextNode.next;
				} else {					
					prevNode = nextNode;
					nextNode = nextNode.next;
				}
			}
			
			currentNode = currentNode.next;
			prevNode = currentNode;
			if(currentNode != null) {			
				nextNode = currentNode.next;
			}
		}
		
	}
	
}
