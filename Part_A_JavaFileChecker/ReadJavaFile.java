import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class ReadJavaFile {

	private static final Object openB = '{';
	private static final Object closeB = '}';
	static BracketStack aBracketStack = new BracketStack();

	/**
	 * Main method for the ReadJavaFile program
	 *
	 */
	public static void main(String[] args) {

		for (String s: args) {

			readFile(s);
		}

		checkStackEmpty();
		result();

	}//end main

	//-----------------------------------------------------------------
	/**
	 * A method to read in a java file line by line.
	 * Each line is sent to the checkLine method
	 *
	 */
	public static void readFile(String fileToCheck){

			String str;
			try {
			File f1 = new File(fileToCheck);

			FileReader fr = new FileReader(f1);
			BufferedReader in = new BufferedReader(fr);

			str = in.readLine();

			while (str != null) {
				checkLine(str);
				str = in.readLine();
				}
				in.close();

			} catch (IOException e) {
				System.out.println("Error: File not found");
			}
	}//end readFile

	//-----------------------------------------------------------------

	/**
	 * A method to check a line of text for curly brackets
	 *
	 */
	public static void checkLine(String strIn){

		for(int i=0; i<strIn.length(); i++){
			Object nextChar = strIn.charAt(i);

			if( nextChar.equals(openB) || nextChar.equals(closeB) ){

				processChar(nextChar);
			}
		}

	}//end checkline

	/**
	 * A method to process a curly bracket
	 *
	 */
	public static void processChar(Object charIn){


		//outer 'if' condition checker to avoid reading a
		//large file if it becomes unbalanced with an illegal '}'
		if( aBracketStack.getBalanced() == true ){

			if( charIn.equals(openB) ){
				aBracketStack.push(charIn);
			}
			else{
				aBracketStack.pop(charIn);
			}

		}//end while

	}//end processChar

	/**
	 * A check to run at end of file read to determine if
	 * there is anything left on the stack, thus 'unbalanced'
	 */
	public static void checkStackEmpty(){

		if(!aBracketStack.isEmpty()){
			aBracketStack.setBalanced(false);
		}
	}//end checkStackEmpty


	/**
	 * print out result of file-check
	 */
	public static void result(){
		String result = "";
		if(aBracketStack.getBalanced()){
			result = "Balanced";
		}
		else{
			result = "Unbalanced";
		}
		System.out.println("Result: [" + result + "]");
	}//end result


}// end class









//------------------------------------------------------------------------------
//alternative processChar() method we can use with pop() method  (no parameters)
/*
	public static void processChar(Object charIn){

		//System.out.println("Processing: " + charIn );

		//outer 'if' condition checker to avoid reading a
		//large file if it becomes unbalanced with an illegal '}'
		if( aBracketStack.getBalanced() == true ){

			if( charIn.equals(openB) ){
				aBracketStack.push(charIn);
			}
			else{

				try{
					aBracketStack.pop();
					}
					catch(StackException e){
						System.out.println(e);
						}
			}

		}//end while

	}//end processChar
*/
//-----------------------------------------------------------------------
