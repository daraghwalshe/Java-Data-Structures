package linkedList;


public class ListNode {

	private Object listItem;
	private ListNode next;

	//constructor for the first item node, or item at tail of existing list
	public ListNode(Object newItem){
		listItem = newItem;
		next = null;
	}

	//constructor for item node
	public ListNode(Object newItem, ListNode nextNode){
		listItem = newItem;
		next = nextNode;
	}

	//----------------------------------------------------

	public void set(Object thisItem){
		listItem = thisItem;
	}

	public Object getItem(){
		return listItem;
	}

	public void setNext(ListNode thisNode){
		next = thisNode;
	}

	public ListNode getNext(){
		return next;
	}


}//end class
