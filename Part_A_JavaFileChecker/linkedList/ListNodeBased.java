package linkedList;


public class ListNodeBased implements ListNodeInterface{

	private ListNode head;
	private ListNode curr;
	private ListNode prev;
	private int listSize = 0;

	//constructor for our new list
	public ListNodeBased(){
		head = null;
	}

	//-------------------------------------------------------

	@Override
	/*
	 * (non-Javadoc)
	 * @see ListNodeInterface#isEmpty()
	 * returns true if the list is empty
	 */
	public boolean isEmpty() {

		if(head == null){
			return true;
			}
			else{
				return false;
				}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see ListNodeInterface#size()
	 * returns the number of items on the list
	 */
	public int size() {
		return listSize;
	}

	@Override
    /**
	 * @see ListNodeInterface#add(java.lang.Object)
	 * method to add first item, or item at end of list, ie: no index passed
	 */
	public void add(Object item) throws ListException{
		if(item != null){

			curr = head;
			if( isEmpty() ){
				//System.out.println("empty list found");
				head = new ListNode(item);
			}
			else{
				while(curr.getNext() != null){
					curr = curr.getNext();
				}
				ListNode newNode = new ListNode(item);
				curr.setNext(newNode);
			}
			listSize++;
		}
		else{
			throw new ListException("ListException on add method: cannot add null item");
		}
	}//end add method

	@Override
	/*
	 * (non-Javadoc)
	 * @see ListNodeInterface#add(java.lang.Object, int)
	 * adds an item into the list at index passed
	 */
	public void add(Object item, int index) throws ListException, ListIndexOutOfBoundsException {
		if(item != null && index > 0 && index <= listSize+1){
			curr = head;
			ListNode newNode = new ListNode(item);

			for(int i=1; i<index; i++){
				prev = curr;
				curr = curr.getNext();
			}
			newNode.setNext(curr);
			prev.setNext(newNode);
			listSize++;
		}
		else if(item == null){
			throw new ListException("ListException on add method: cannot add null item");
		}
		else if(index <= 0 || index > listSize+1){
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add method: illegal index passed");
		}
	}//end add, method two

	@Override
	/*
	 * (non-Javadoc)
	 * @see ListNodeInterface#get(int)
	 * returns the list item at the index passed
	 */
	public Object get(int index) throws ListIndexOutOfBoundsException {
		curr = head;
		//System.out.println("in get method, looking for no " + index );

		if( index >=0 && index <= this.size() ){
			//System.out.println("Size ok");
			curr = head;
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
	 * (non-Javadoc)
	 * @see ListNodeInterface#remove(int)
	 * removes the item at the index passed
	 */
	public void remove(int index) throws ListIndexOutOfBoundsException {

		if( index >1 && index <= this.size() ){
			curr = head;
			for(int i=1; i<index; i++){
				prev = curr;
				curr = curr.getNext();
			}
			prev.setNext( curr.getNext() );
			listSize--;
		}
		else if( index == 1){
			head = null;
			listSize--;
		}
		else{
			throw new ListIndexOutOfBoundsException("Out of bounds exception on remove method");
			}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see ListNodeInterface#removeAll()
	 * Removes all items from list
	 */
	public void removeAll() {
		curr = head;
		head = null;
		listSize = 0;
	}
	/**
	 * Returns the largest number(assuming we have numbers stored...)
	 */
	public int getLargest(){
		curr = head;
		int largest = (int) curr.getItem();
		while(curr.getNext() != null){
			if(largest < (int) curr.getNext().getItem()){
				largest = (int) curr.getNext().getItem();
			}
			curr = curr.getNext();
		}
		return largest;
	}

	/**
	 * Displays the contents of the list with an index number
	 * for users to identify individual items
	 */
	public void display(){

		if(listSize == 0){
			System.out.println("List is empty.");
		}

		int listIndex = 1;
		curr = head;
		while(curr != null){
			System.out.println( listIndex + " : " + curr.getItem() );
			curr = curr.getNext();
			listIndex++;
		}
		System.out.println();
	}//end display


}//end class
