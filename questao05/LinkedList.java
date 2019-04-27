package questao05;
import questao05.Node;

public class LinkedList {
	
	Node head;
	
	// A method to insert nodes in a linked list. If the list is null, we set the new node to be the head of the list, otherwise we search until the end of the list to place the new node there.
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
	
	// A method to print on the screen each node of the list for visualization purpose.
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
				//We compare the current node value to the value of each next node in the list.
				if (currentNode.value.equals(nextNode.value)) {
					//If we find a match, we set the previous node to link with the node after the node we're comparing with the current node.
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
