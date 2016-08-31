
/**
 * A Class to create and manipulate Student objects
 * @author daragh walshe B00064428
 *
 */
public class Student {

	private String name;
	private boolean isLoggingOff;
	
	/**
	 * constructor for student objects
	 * @param nameIn
	 */
	public Student(String nameIn){
		name = nameIn;
		isLoggingOff = false;
	}//end constructor
	
	/**
	 * A method to get a students name
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * A method to see if a student wants to log off the network
	 * @return true student is logging off
	 */
	public boolean loggingOff(){
		return isLoggingOff;
	}
	
	/**
	 * A method to randomly determine if a student wants to log off
	 * 50% chance of changing isLoggingOff boolean to true
	 */
	public void askIfStaying(){
		
		double tiredness = Math.random();	
		if(tiredness > 0.5){
			isLoggingOff = true;
		}
	}

}//end class





