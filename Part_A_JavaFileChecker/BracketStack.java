import linkedList.ListNodeBased;

/**
 * @author daragh walshe B00064428
 *
 */
public class BracketStack implements StackInterface{

	private ListNodeBased myBracketStack;
	private boolean balanced;
	private final Object openCurlyB = '{';
	private final Object closeCurlyB = '}';

	public BracketStack(){
		balanced = true;
		myBracketStack = new ListNodeBased();
	}//end constructor


	@Override
	public boolean isEmpty() {
		return myBracketStack.isEmpty();
	}

	@Override
	public void popAll() {
		myBracketStack.removeAll();
	}

	@Override
	public void push(Object newItem) throws StackException {
		if( newItem.equals(openCurlyB) ){
			myBracketStack.add(newItem);
		}
		else throw new StackException("Error: StackException in push method, only opening curly brackets allowed on stack");
	}

	@Override
	public Object pop() throws StackException {

		if( !myBracketStack.isEmpty() ){
			System.out.println("Inside Pop size is " + myBracketStack.size());
			Object lastIn = new Object();
			lastIn = myBracketStack.get(myBracketStack.size());
			myBracketStack.remove(myBracketStack.size());
			return lastIn;
		}
		else{
			balanced = false;
			throw new StackException("Error: StackException in push method, stack is empty");
			}
	}

	public void pop(Object newItem){
		if( newItem.equals(closeCurlyB) && myBracketStack.isEmpty() ){
			balanced = false;
		}
		if( !myBracketStack.isEmpty() ){
			Object lastIn = new Object();
			lastIn = myBracketStack.get(myBracketStack.size());
			myBracketStack.remove(myBracketStack.size());
		}
	}


	@Override
	public Object top() throws StackException {
		if( !myBracketStack.isEmpty() ){
			return myBracketStack.get(myBracketStack.size());
		}
		else throw new StackException("Error: StackException in top method, stack is empty");
	}


	public void setBalanced(boolean thisTruth){
		balanced = thisTruth;
	}

	public boolean getBalanced(){
		return balanced;
	}

}







