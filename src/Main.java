import java.security.MessageDigest;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		
		boolean finished = false;
		
		List<String> ListOfHashes = new ArrayList<>();
		Scanner sc = new Scanner(System.in); //Scanner to get option
		Scanner str = new Scanner(System.in); //Scanner to get file name
		String strInput; //Hold value of string input
		String fileName; // hold value of fileName input
		


		while(finished == false) // while loop ! finished 
		{
			
			menu(); //display menu
			int choice = sc.nextInt(); // get user choice
			
			
				switch(choice) { //switch through inputs 
				
				case 1: // input 1
					System.out.println("Please enter a string"); //ask for string to hash
					strInput = str.next(); // assign input from scanner
					Hash_MD5(strInput,ListOfHashes); // run hash function
					break;
				
				case 2: // input 2
					
					System.out.println("Please enter a string"); // ask for string to hash
					strInput = str.next(); // assign input from scanner
					Hash_SHA256(strInput,ListOfHashes); // run hash function
					break;
					
				case 3: //input 3
					
					System.out.println("Please enter a string"); //ask for string to hash
					strInput = str.next(); // assign input from scanner
					Hash_SHA1(strInput,ListOfHashes); // run hash function
					break;
					
					
				case 4: //input 4 
					
				boolean done = false; //needed to create input loop
				
				while(done == false) //while !true
				{
					try { //try this
			
					System.out.println("Please enter a file name (Including file extension) "); //ask for a file name to hash
					fileName = str.next(); //assign input from scanner
					file_HashMD5(fileName,ListOfHashes); // run the file hash function
					done = true; //finish input if valid filename
					}
					catch(Exception e) //if filename not valid
					{
						System.out.println("Please enter a file name (Including file extension) "); //ask for a file name to hash
						fileName = str.next(); //assign input from scanner
					}
				}
				
					break;
					
				case 5: //input 5
					
						
				 boolean done2 = false; //needed to create input loop
				 
				 while(done2 == false) //while !true
				 {
					try //try this
					{
					
					System.out.println("Please enter a file name (Including Extension) "); //ask for a file name to hash
					fileName = str.next(); //assign input from scanner
					file_HashSHA256(fileName,ListOfHashes); // run the file hash function
					done2 = true;
					
					}
					catch(Exception e) //if filename not valid
					{
						System.out.println("Please enter a file name (Including Extension) "); //ask for a file name to hash
						fileName = str.next(); //assign input from scanner
					}
				 }
				
					break;
					
				case 6: //input 6
					
					
					boolean done3 = false; //needed to create input loop
					
					while(done3 == false) //while !true
					{
						
						try //try this
						{
					System.out.println("Please enter a file name (Including Extension "); //ask for a file name to hash
					fileName = str.next(); //assign input from scanner
					file_HashSHA1(fileName,ListOfHashes); // run the file hash function
					done3 = true;
						}
						catch(Exception e) //if filename not valid
						{
							System.out.println("Please enter a file name (Including Extension "); //ask for a file name to hash
							fileName = str.next(); //assign input from scanner
						}
					}
					break;
						
					
				case 7: //input 7
					
					boolean done4 = false; //needed to create input loop
					
					while(done4 == false) //while !true
					{
						
					 try //try this
					 {
						 
					System.out.println("Please enter a file name (Including Extension) "); //ask for file name to check hashes against
					fileName = str.next(); //assign input from scanner
					sig_Detection(fileName,ListOfHashes); //run the signature detection function
					done4 = true;
					 }
					 catch(Exception e) //if filename not valid
					 {
						 System.out.println("Please enter a file name (Including Extension) " ); //ask for file name to check hashes against
							fileName = str.next(); //assign input from scanner
					 }
					}
					
					break;
					
				case 8: //input 8
					exit(); //run the exit function
					
				default: System.out.println("Please enter a valid option"); // set default if user inputs invalid choice
					
					
				}
				
			}
				
			
		sc.close(); // close scanner
		str.close(); //close scanner
		
		}
	
	
	
	public static void menu()
	{
		
		System.out.println("                                          ");
		System.out.println("******************************************");
		System.out.println("******************************************");
		System.out.println("Welcome to my Hashing Application! *******");
		System.out.println("******************************************");
		System.out.println("******************************************");
		System.out.println("Press 1 - For MD5 String Hashing *********");
		System.out.println("Press 2 - For SHA - 256 String Hashing ***"); // print out the different menu options
		System.out.println("Press 3 - For SHA - 1 Sring Hashing  *****");
		System.out.println("Press 4 - File MD5 Hashing   *************");
		System.out.println("Press 5 - File SHA - 256 Hashing *********");
		System.out.println("Press 6 - File SHA - 1 Hashing   *********");
		System.out.println("Press 7 - For Signature Detection ********");
		System.out.println("Press 8 - To Exit The Application ********");
		System.out.println("******************************************");
		System.out.println("******************************************");
		
		System.out.println("\n Please Enter Your Option Here: "); // ask user for a choice
	}
	
	
	public static void Hash_MD5(String strInput,List<String>ListOfHashes) throws Exception // take in the string to hash from scanner
	
	 {
		
	 MessageDigest md = MessageDigest.getInstance("MD5"); // Get the MD5 instance 
	 // SHA-256 or MD5 or SHA-1

	 md.update(strInput.getBytes());
	 byte byteData[] = md.digest();

	 StringBuffer hexString = new StringBuffer();
	 for (int i=0;i<byteData.length;i++) { //for every bite
	 String hex=Integer.toHexString( byteData[i] & 0xff ); //get hex value
	 if(hex.length()==1) hexString.append('0');
	 hexString.append(hex);
	 }
	 System.out.println("Hash Value " + hexString.toString()); //output hash 
	 
		if(ListOfHashes.contains(hexString.toString())) //if arraylist already has this hash
		{
			System.out.println("This hash has already been added"); //notify user
			
		}
		else {
			ListOfHashes.add(hexString.toString()); //add the hash to arraylist
			System.out.println("Hash has been added to the database");	 //notify the user		
		}
	 
	 }
	
	
	public static void Hash_SHA256(String strInput,List<String>ListOfHashes) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256"); //sha 256
		 // SHA-256 or MD5 or SHA-1

		 md.update(strInput.getBytes());
		 byte byteData[] = md.digest();

		 StringBuffer hexString = new StringBuffer();
		 for (int i=0;i<byteData.length;i++) { //for every bite
		 String hex=Integer.toHexString( byteData[i] & 0xff ); //get hex value
		 if(hex.length()==1) hexString.append('0');
		 hexString.append(hex);
		 }
		 System.out.println("Hash Value " + hexString.toString()); //print out hash
		 
		 if(ListOfHashes.contains(hexString.toString())) //if array list already has the hash
			{
				System.out.println("This hash has already been added"); //notify user
				
			}
			else {
				ListOfHashes.add(hexString.toString()); // else add hash to arraylist
				System.out.println("Hash has been added to the database");	 //notify user		
			}
		 
		 }
	
	
	public static void Hash_SHA1(String strInput,List<String>ListOfHashes) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //sha 1
		 // SHA-256 or MD5 or SHA-1

		 md.update(strInput.getBytes());
		 byte byteData[] = md.digest();

		 StringBuffer hexString = new StringBuffer();
		 for (int i=0;i<byteData.length;i++) { // for every bite
		 String hex=Integer.toHexString( byteData[i] & 0xff ); // get hex value
		 if(hex.length()==1) hexString.append('0');
		 hexString.append(hex);
		 }
		 System.out.println("Hash Value " + hexString.toString()); //print out hash
		 
		 if(ListOfHashes.contains(hexString.toString())) //if arraylist already has hash
			{
				System.out.println("This hash has already been added"); //notify user
				
			}
			else {
				ListOfHashes.add(hexString.toString()); // else add hash to arraylist
				System.out.println("Hash has been added to the database");	//notify user		
			}
	}
	
	
	public  static void file_HashMD5(String fileName,List<String> ListOfHashes) throws Exception
	{
		
	
		 MessageDigest md1 = MessageDigest.getInstance("MD5"); //md5
		 
		 String currentDir = Paths.get(".").toAbsolutePath().normalize().toString(); //get the directory
		 
		String  filePath = currentDir+"\\"+ fileName; //filepath = directory + the file name

		FileInputStream fis = new FileInputStream(filePath); //get the file
		 byte[] dataBytes = new byte[1024]; //data array
		 int nread = 0;
		 while ((nread = fis.read(dataBytes)) != -1) { //while reading file
		 // md is the MessageDigest instance
		 md1.update(dataBytes, 0, nread); //get every bite
		 };
		 
		 fis.close();

		 byte byteData[] = md1.digest();
		 
		 StringBuffer hexString = new StringBuffer();
		 for (int i=0; i< byteData.length; i++) { //for every bite
		 String hex=Integer.toHexString(byteData[i] & 0xff ); //get hex value
		 if(hex.length()==1) hexString.append('0'); 
		 hexString.append(hex);
		 }
		 System.out.println("Hex Value " + hexString.toString()); //print out hash
		 
		if(ListOfHashes.contains(hexString.toString())) //if arraylist already has hash
		{
			System.out.println("This hash has already been added"); //notify user
			
		}
		else {
			ListOfHashes.add(hexString.toString()); // else add hash to arraylist
			System.out.println("Hash has been added to the database");	 //notify user		
		}
		
	}
		 
	
	public static void file_HashSHA256(String fileName,List<String>ListOfHashes) throws Exception
	{
		 MessageDigest md1 = MessageDigest.getInstance("SHA-256"); // sha 256
		 
		 String currentDir = Paths.get(".").toAbsolutePath().normalize().toString(); //get the directory
		 
		 String  filePath = currentDir+"\\"+ fileName; // filepath = directory + the file name

			FileInputStream fis = new FileInputStream(filePath); //get the file
			 byte[] dataBytes = new byte[1024]; //data array
			 int nread = 0;
			 while ((nread = fis.read(dataBytes)) != -1) { //while reading file
			 // md is the MessageDigest instance
			 md1.update(dataBytes, 0, nread); //get every bite
			 };
			 
			 fis.close();

			 byte byteData[] = md1.digest();
			 
			 StringBuffer hexString = new StringBuffer();
			 for (int i=0; i< byteData.length; i++) { //for every bite
			 String hex=Integer.toHexString(byteData[i] & 0xff ); //get hex value
			 if(hex.length()==1) hexString.append('0');
			 hexString.append(hex);
			 }
			 System.out.println("Hash Value " + hexString.toString()); //print out hash
			 
			 if(ListOfHashes.contains(hexString.toString())) //if arraylist already has hash
				{
					System.out.println("This hash has already been added"); //notify user
				}
				else {
					ListOfHashes.add(hexString.toString()); // else add hash to arraylist
					System.out.println("Hash has been added to the database");	//notify user			
				}
				
	}
	
	
	public static void file_HashSHA1(String fileName,List<String>ListOfHashes) throws Exception
	{
		 MessageDigest md1 = MessageDigest.getInstance("SHA-1"); //sha 1
		 
		 String currentDir = Paths.get(".").toAbsolutePath().normalize().toString(); //get the directory of where the files are stored
		 
		 String  filePath = currentDir+"\\"+ fileName; //file path = current directory + filename

			FileInputStream fis = new FileInputStream(filePath); //import file from filepath
			 byte[] dataBytes = new byte[1024]; //data array
			 int nread = 0;
			 while ((nread = fis.read(dataBytes)) != -1) { //while reading file
			 // md is the MessageDigest instance 
			 md1.update(dataBytes, 0, nread); //get byte
			 };
			 
			 fis.close();
			 

			 byte byteData[] = md1.digest();
			 
			 StringBuffer hexString = new StringBuffer();
			 for (int i=0; i< byteData.length; i++) { //for every bite
			 String hex=Integer.toHexString(byteData[i] & 0xff ); //get hex value
			 if(hex.length()==1) hexString.append('0');
			 hexString.append(hex);
			 }
			 System.out.println("Hash Value " + hexString.toString()); //print out hash
			 
			 if(ListOfHashes.contains(hexString.toString())) //if arraylist already has hash
				{
					System.out.println("This hash has already been added"); //notify user
					
				}
				else {
					ListOfHashes.add(hexString.toString()); // else add hash to arraylist
					System.out.println("Hash has been added to the database");	//notify user				
				}
				
	}
	
	public static void sig_Detection(String fileName,List<String>ListOfHashes) throws Exception
	{
		
		FileWriter writer = new FileWriter("hashInputs.txt"); //new file writer object / assign name of new text file
		for(String inputHashes : ListOfHashes) //for loop to iterate over whole arrayList
		{
			writer.write(inputHashes + System.lineSeparator()); //write hashes separated by a line
		}
		writer.close(); //close the writer 
		
		
		BufferedReader inputHashes = new BufferedReader(new FileReader("hashInputs.txt")); // read in the new text file of the users hashes
		
		BufferedReader  storedHashes = new BufferedReader(new FileReader(fileName)); //read in a file that the user specifies by its file name
		
		
		List<String> hashes = new ArrayList<>(); // new array list of hashes
		
		String hash; //new string 
		
		while((hash = inputHashes.readLine()) != null) //while the string is not empty 
		{
			hashes.add(hash); //add the hash within the file to the arrayList
		}
		
		String hash2; // new string
		
		while((hash2 = storedHashes.readLine()) != null) // while string is not empty 
		{
			if(hashes.contains(hash2)) // if string contains the same hash
			{
				System.out.println("Hash Match found = " + hash2); //notify user
			}
			else
			{
				System.out.println("No matches found"); //notify user if theres no matches otherwise
			}
		}
		
		inputHashes.close(); //close buffered reader
		storedHashes.close(); //close buffered reader
		System.out.println("Signature Detection scan complete"); //notify user scan is complete
		
		
	
	}
	
	
	public static void exit()
	{
		System.exit(1); //terminate program
	}
	
		
}
