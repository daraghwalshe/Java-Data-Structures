package linkedList;

/**
 * A Class to create and manipulate listNode objects
 * @author daragh
 *
 */
public class ListNode {
	
	private Object listItem;
	private ListNode next;
	
	/**
	 * constructor for the first item node, or item at tail of existing list
	 * this method takes a single parameter
	 * @param newItem, an object to add to the list
	 */
	public ListNode(Object newItem){
		listItem = newItem;
		next = null;
	}

	/**
	 * constructor for item node
	 * this method takes two parameters
	 * @param newItem, an object to add to the list
	 * @param nextNode, a reference to the next list item
	 */
	public ListNode(Object newItem, ListNode nextNode){
		listItem = newItem;
		next = nextNode;
	}
	
	//----------------------------------------------------
	
	/**
	 * A method to set the object in the listNode
	 * @param thisItem, object to store in listNode
	 */
	public void set(Object thisItem){
		listItem = thisItem;
	}
	
	/**
	 * Returns the item stored in the listNode
	 * @return listItem, the stored object
	 */
	public Object getItem(){
		return listItem;
	}
	
	/**
	 * Sets the nodes reference to the next item on the list
	 * @param thisNode, the next item reference
	 */
	public void setNext(ListNode thisNode){
		next = thisNode;
	}
	
	/**
	 * Returns the listNodes next reference
	 * @return next, a reference to the next item on the list
	 */
	public ListNode getNext(){
		return next;
	}
	
	
}//end class
