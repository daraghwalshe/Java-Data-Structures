package linkedList;


public interface ListNodeInterface {

	//returns true if the list is empty
	public boolean isEmpty();

	//returns an integer representing the amount of items on the list
	public int size();

	//simply adds an item to the end of the list
	public void add(Object item) throws ListException;

	//adds an item to a position(index) in the list
	public void add(Object item, int index) throws ListException, ListIndexOutOfBoundsException;

	//returns an item from a known place in the list(index)
	public Object get(int index) throws ListIndexOutOfBoundsException;

	//removes the item at the index passed
	public void remove(int index) throws ListIndexOutOfBoundsException;

	//removes all items from the list
	public void removeAll();

}//end interface
