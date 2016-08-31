/**
 * 
 */
package linkedList;

/**
 * @author Daragh Walshe B00064428
 *
 */
public class CircularNodeList implements CircularListNodeInterface{
	
	private ListNode list;
	private ListNode curr;
	private ListNode prev;
	private int listSize = 0;
	
	//constructor for our new list
	public CircularNodeList(){
		list = null;
	}//end constructor
	//-------------------------------------------------------

	@Override
	/* @see ListNodeInterface#isEmpty()
	 * returns true if the list is empty
	 */
	public boolean isEmpty() {
		//return (head.getItem() == null);
		if (list == null)
			return true;
		else
			return false;
	}
	
	@Override
	/*
	 * @see ListNodeInterface#size()
	 * returns the number of items on the list
	 */
	public int size() {
		return listSize;
	}
	
	@Override
	/*
	 * @see ListNodeInterface#add(java.lang.Object)
	 * method to add first item, or item at end of list, ie: no index passed
	 */
	public void add(Object item) throws ListException{	
		if(item != null){	
			//create a new node to add to list
			ListNode newNode = new ListNode(item);

			if( isEmpty() ){
				//System.out.println("empty list found");
				list = newNode;
				list.setNext(newNode);	
			}
			else{
				newNode.setNext(list.getNext());
				list.setNext(newNode);	
			}
			listSize++;
		}
		else {
			throw new ListException("ListException on add method: cannot add null item");
		}
	}//end add method	
	

	@Override
	/*
	 * @see ListNodeInterface#get(int)
	 * returns the list item at the index passed
	 */
	public Object get(int index) throws ListIndexOutOfBoundsException {

		if( index >= 0 && index <= this.size() ){
			curr = list.getNext();	
			for(int i=1; i<index; i++){
				curr = curr.getNext();		
			}
			return curr.getItem();
		}
		else{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get method: illegal index passed");
			}
	}

	@Override
	/*
	 * @see ListNodeInterface#remove(int)
	 * removes the item at the index passed
	 */
	public void remove(int index) throws ListIndexOutOfBoundsException {
		
		if( index == 1 && this.size() == 1){
				removeAll();
		}	
		else if( index >=1 && index <= this.size() ){
			curr = list;
			for(int i=1; i<=index; i++){
				prev = curr;
				curr = curr.getNext();		
			}
			prev.setNext( curr.getNext() );
			listSize--;					
		}		
		else{
			throw new ListIndexOutOfBoundsException("Out of bounds exception on remove method");
			}			
	}
	
	
	@Override
	/*
	 * @see ListNodeInterface#removeAll()
	 * Removes all items from list
	 */
	public void removeAll() {
		list = null;
		listSize = 0;
	}	

	/**
	 * Displays the contents of the list
	 */
	public void display(){
		
		if(!isEmpty()){
			int listIndex = 1;
			ListNode first= list.getNext();
			curr = first;
			do{				
				System.out.println( listIndex + " : " + curr.getItem() );
				curr = curr.getNext();
				listIndex++;			
			}while(curr != first);
			System.out.println();
		}
		else{
			System.out.println("List is empty.");
		}	
	}//end display	

	
	
}//end class









