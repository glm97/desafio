package questao07;

import questao07.Node;
import questao07.NotFoundIntersectionException;

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
	
	// This is the method responsible for finding intersections, if they don't exist it throws an exception.
	public Node findIntersection(LinkedList alist, LinkedList blist) throws NotFoundIntersectionException {
		Node r = new Node (null);
		Node aNode = alist.head;
		Node bNode = blist.head;
		boolean leave = false;
		//For every node of alist we compare the next node of it with the next node of every node from blist. 
		while((aNode.next != null) && (leave == false)) {
			while((bNode.next != null) && (leave == false)) {
				if(aNode.next == bNode.next) {
					r = aNode.next;
					leave = true;
				} else {
					bNode = bNode.next;
				}
			}
			
			bNode = blist.head;
			aNode = aNode.next;				
		}
		if(r != null) {
			return r;
		} else {
			throw new NotFoundIntersectionException();
		}
	}
	
	// We use this method to concatenate two lists, by making the last node of the first list link to the head of the second list.
	public LinkedList concatLists(LinkedList alist, LinkedList blist) {
		if(alist.head == null) {
			alist.head = blist.head;
		} else {
			Node currentNode = alist.head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
				}
				currentNode.next = blist.head;	
		}
		return alist;
	}

}
