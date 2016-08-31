package linkedList;

/**
 * An interface for the Circular Linked List ADT
 * @author daragh walshe B00064428
 *
 */
public interface CircularListNodeInterface {
	
	/**
	 * Returns true if the list is empty otherwise returns false
	 * @return a boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Returns an integer representing the amount of items on the list
	 * @return size
	 */
	public int size();
	
	/**
	 * Simply adds an item to the end of the list
	 * @param item, an object to add to the list
	 * @throws ListException
	 */
	public void add(Object item) throws ListException;
	
	/**
	 * Returns an item from a known place in the list(index)
	 * @param index, the place on the list
	 * @return an object from the list position(index) 
	 * @throws ListIndexOutOfBoundsException
	 */
	public Object get(int index) throws ListIndexOutOfBoundsException;
	
	/**
	 * Removes the item at the position(index) passed
	 * @param index, the position on the list
	 * @throws ListIndexOutOfBoundsException
	 */
	public void remove(int index) throws ListIndexOutOfBoundsException;
	
	/**
	 * Removes all items from the list
	 */
	public void removeAll();
	
}//end interface
