import linkedList.CircularNodeList;

/**
 * A class to simulate a token ring circular network 
 * populated with a list of students
 * The list is traversed and students asked if they want to stay
 * The list is traversed continuously until it is empty
 * 
 * @author daragh walshe B00064428
 *
 */
public class StudentNetwork {

	//an array filled with all student names
	private static final String[] USERS = {"Aloysius Amazu","Ahmadollah Nazari","Shane Mac Mathuna","Oonagh Maher",
			"Charles John","Inta Buseniece","Michelle Ruth","Aaron Flanagan ","Kevin Nguyen","Mindaugas Kluonis",
			"Bernado Jose","Dmitrij Borovkov","David Breen ","Piotr Masio","Cosmin Mirt","Jesus Lavilla",
			"Diego Malo","Alejandro Menal","Guillermo Ramos","Dereck O Brien","Conor McKeogh","Ciaran O Meara",
			"Bogdans Krutilins","Jonathan Grant","Shane Lowry","David Malone","David Concarr","Conor Smith",
			"John Flood","Ciaran Boland","Andrew Kelly","Szabolcs Kovacs","Ciaran Beirne","Daragh Walshe",
			"Omar Ibrahim","Thomas Colombet","Samuel Louden","Michael James","Jasmine Naami","Alan Leech",
			"Darragh Lambe","Aminu Ojekhebholo","David Cushen","Andrew Meakin","David Kelly","Adem Slavotic",
			"Michael Korb","Martin Deegan-Sheridan","Anthony Creighton","Darren Alder","Keith Somers","Martin Zuber",
			"Keith Rodden","Seth Harbottle","Paul Cairns","Chris Arndt","Mael Pons"};
	
	//create the network(circular linked list)
	private static CircularNodeList network = new CircularNodeList();
	
	
	/**
	 * Main method for the Student network program
	 * @param args
	 */
	public static void main(String[] args) {
		
		fillWithStudents();	
		patrolNetwork();
		
	}//end main

	
	/**
	 * Method to fill the circular list with student Objects
	 */
	public static void fillWithStudents() {
		
		Student tempStudent;
		
		for(int i=0; i<USERS.length; i++){
			
			tempStudent = new Student(USERS[i] + " B000" + (i+1));
			network.add(tempStudent);
			System.out.println(tempStudent.getName() + " is logging on");
					
			//pause 50 millisecs each iteration
			try {
				Thread.sleep(50L);
				}
				catch (Exception e) {
					System.out.println("Help i'm broken!" + e);	
				}					
		}//end for loop
		
		System.out.println("\nAll students logged on\n");
		
	}//end fillWithStudents
	
	
	/**
	 * Method to loop around circular network
	 * checking each student in turn
	 * if student wants to leave, they are removed from the network.
	 */
	public static void patrolNetwork() {
		
		int i=1;
		Student thisStudent;
		
		do{		
				thisStudent = (Student)network.get(i);
				
				//pause up to 250 ms
				try {
					Thread.sleep(1 + (int)(Math.random()*250));
					}
					catch (Exception e) {
						System.out.println("Help i'm broken!" + e);	
					}
				
				//will randomly set isLoggingOff boolean in the student
				thisStudent.askIfStaying();
				
				if(thisStudent.loggingOff()){
					network.remove(i);
					System.out.println(thisStudent.getName() + " is logging off");	
				}
				
				i++;
				if(i > network.size() ){ 
					i = 1; 
					System.out.println("\n---------  full circuit  --------------");
					System.out.println("No of Students still logged on: " + network.size() + "\n");
				}
					
		}while(network.size() > 0);//end while network is not empty
		
		System.out.println("All students logged off");
		
	}//end patrolNetwork
	
	
}//end class











//--------------------------------------------------------------------
//Alternative patrol network method, possibly not as efficient
/*
public static void patrolNetwork() {
	
	while(network.size() > 0){
		
		System.out.println("No. of Students left: " + network.size() + "\n");
		
		//for(int i= network.size(); i>0; i--){
		for(int i=1; i<=network.size(); i++){
			Student thisStudent = (Student)network.get(i);
			
			try {
				//int wait = 100 + (int)(Math.random()*1400);
				Thread.sleep(1 + (int)(Math.random()*100));
				}
				catch (Exception e) {
					System.out.println("Help i'm broken!" + e);	
				}
			
			thisStudent.askIfStaying();
			if(thisStudent.loggingOff()){
				network.remove(i);
				System.out.println(thisStudent.getName() + " is logging off");	
			}	
		}//end for loop	
		
		System.out.println("\n------------full circuit-----------------");
		
	}//end while network if not empty
	
	System.out.println("List size: " + network.size());
	System.out.println("All students logged off");
	
}//end patrolNetwork
*/
//--------------------------------------------------------------------------





