package questao07;
//import java.util.Scanner;
import questao07.LinkedList;;

public class Main {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		
		LinkedList alist = new LinkedList();
		LinkedList blist = new LinkedList();
		LinkedList clist = new LinkedList();
		
		alist.insertNode(alist, "c");
		alist.insertNode(alist, "a");
		alist.insertNode(alist, "e");
		alist.insertNode(alist, "h");
		
		blist.insertNode(blist, "d");
		blist.insertNode(blist, "f");

		
		clist.insertNode(clist, "j");
		clist.insertNode(clist, "b");
		clist.insertNode(clist, "a");
		
		alist.concatLists(alist, clist);
		blist.concatLists(blist, clist);
		
		try {
			Node result = alist.findIntersection(alist, blist);
			System.out.println(result);
			System.out.println(result.value);
		} catch (NotFoundIntersectionException e) {
			System.out.println("We couldn't find and intersection between these lists.");
		}
		
		
		
		//in.close();
	}

}
