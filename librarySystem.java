import java.util.Scanner;
public class librarySystem{

//return weather the stock is available and is also the final step in the command MakeAnLoan so it returns Successful to show that the loan was made Successfully

    public static String MakeAnLoan(int row_index, String[][] stockArray){

//Confirms if the item was found

		if(row_index == -1){
			return "Not found";
		}

//Confirms Stock is available

		if(stockArray[row_index][1].equals("0")){
			return "There is no stock available";
		}
		System.out.println("Succssess!");
		return "Success!";
		
		
	}

//returns the row index that the stock is at 

	public static int indexItemInStock(String[][] stockArray, String item){

//looks for the row

		for(int i=0;i<stockArray.length;i++){
			if(stockArray[i][0].equals(item)){
				return i;
			}	
		}

//Displays the error if it wasnt found

		return -1;
					
	}
//Creates the item code

	public static String createItemCode(int row_index,String[][] stockArray,String item){

//declares temp equal to the item name

		String temp=stockArray[row_index][0];

//Upper cases all the letters in the string

		item=item.toUpperCase();
//Sets a string called abreviation equal to ""

		String abreviation="";

//Splits the string for every instance of " " and stores the diffrent parts into a one-dimensional array

		String[] item_1 = item.split(" ");
		for(int i=0;i<item.length();i++){

//declaring temp_item equal to the chacter at i for the string item

		String temp_item=Character.toString(item.charAt(i));

//checks to see if temp is equal to " "

			if(temp_item.equals(" ")){
				
//sets abbreviation equal to value in the positio of the array item_1[0] and gets the char at the space 0.It then does the same for the item_1[1] and concatinates them together

				abreviation+=item_1[0].charAt(0);
				abreviation+=item_1[1].charAt(0);

// break the for loop so the ID does have multiple instances of the abreviation

				break;
			}
			else{

//if item is only one word the else statment just takes the first letter the word

				abreviation+=item.charAt(0);

//breaks the for loop so the ID doesnt have multiple instances of the abreviation

				break;
			}
		}

//Checks if the item is in stock so the number can be used for the item ID

		if(stockArray[row_index][1].equals("0")){
			System.out.println("Sorry,item out of stock!");
			return "-1";

		}

//concatinates all the components of item_ID together amd returns item_ID

		String item_ID="CS"+abreviation+"-"+stockArray[row_index][1];
		return item_ID;
	}

//Displays the array loanArray

	public static void DisplayLoans(String[][] loanArray){
		for(int i=0;i<loanArray.length;i++){
			for(int j=0;j<loanArray[0].length;j++){

//Prints each cell of the array

				System.out.print(loanArray[i][j]+"\t");
			}

//After every person the \n enters a new line for the next persons information

			System.out.print("\n");
		}
	}

//Displays the array stockArray

	public static void DisplayItems(String[][] stockArray){
		for(int i=0;i<stockArray.length;i++){
			for(int j=0;j<stockArray[0].length;j++){

//Prints each cell of the array

				System.out.print(stockArray[i][j]+"\t");
			}

//After every person the \n enters a new line for the next persons information

			System.out.print("\n");
		}
	}

//checks to see if the names have any numbers

 	public static int  isAlphabetic(String name){
 	   for(int i=0;i<name.length();i++){

//declares c equal to the charecter in name at the the instance of i 

 	   	    char c= name.charAt(i);

//checks if there are any numbers

		    if((c >= '0' && c <= '9')){

//prints the error if there are numbers

		        System.out.println("Error, "+name+" is an invalid augment!");
			  System.out.println("Unsuccessful!");
			  return -1;	
	
		    }
 	    }
		return 1;
	}
	

//Validates customer ID

	public static Boolean isCustomerIdValid(String ID){

//checks to see if the string starts with 80

		if(!ID.substring(0,2).equals("80")){

//error if it doesn't

			System.out.println("Unsuccessful! The "+ID+" is an invalid augment!");
			return false;
		}
		else{
			return true;
		}
	}

//validates if the item is an actual item that is being rented out

	public static Boolean isValidItem(String item, String[][] stockArray){
		for(int i=0;i<stockArray.length;i++){
			if(item.equals(stockArray[i][0])){
				return true;
			}
		}

//error if it isn't

		System.out.println("Unsuccessful!, Invalid Item's name");
		return false;
	}

//finds the next available row in the array loanArray

    	public static int getNumLoans(String[][] loanArray){
	   	for(int i=0;i<loanArray.length;i++){
			if(loanArray[i][0].equals("available")){
				return i;
			}
		}

//error if loanArray is full

		System.out.println("loanArray is full!");
		return -1;
	}

//finds the ID of the person returning an item in loanArray

	public static int returnRecord(String[][] loanArray, String ID){
		for(int i=0;i<loanArray.length;i++){
			if(loanArray[i][2].equals(ID)){

//Shows where it was found

				System.out.println("The ID was found at index: "+i);
				return i;
			}
		}

//If the ID is not there it displays an error

		System.out.println("ID is not registered");
		System.out.println("Unsuccessful!");
		return -1;
	}

//finds the item_ID of the item being returned in loanArray

	public static int itemIdCheck(String[][] loanArray, String item_ID){
		for(int i=0;i<loanArray.length;i++){
			if(loanArray[i][3].equals(item_ID)){

//Shows where it is found

				return i;
			}
		}

//Shows an error if it wasn't found

		System.out.println("Item ID is not registered");
		System.out.println("Unsuccessful!");
		return -1;
	}

//fills the loan Array with the information taken from MakeAnLoan

	public static void loan_filler(String first_name, String last_name, String ID, String item, String item_ID, String[][] loanArray, String date_out, String notes, int loan_index){	
		loanArray[loan_index][0]=first_name;
		loanArray[loan_index][1]=last_name;
		loanArray[loan_index][2]=ID;
		loanArray[loan_index][3]=item_ID;
		loanArray[loan_index][4]=item;
		loanArray[loan_index][5]=date_out;
		loanArray[loan_index][7]=notes;
	}
	
//Main method

	public static void main(String[] args){

//initialize Scanner

		Scanner input= new Scanner(System.in);

//Set stockArray with values

		String [][] stockArray={{"VGA converter","5"},{"Camera","5"},{"HDMI converter","5"},{"Point laser","5"},{"Laptop","5"},{"Microphone","5"},{"Headphone","5"}};

//Set loanArray size
	
		String[][] loanArray =new String[6][8];

//Initialize loanArray with available

		for(int i=0;i<loanArray.length;i++){
			for(int j=0;j<loanArray[0].length;j++){
					loanArray[i][j]="available";
			}
		}

//reapeats the prompt to ask for command

		while(1<2){

//prompts user to enter command
			
			System.out.println("Enter a command: ");

//scans the next line

			String Line_input=input.nextLine();

//splits the line from every instance of " " and stores them into a one-dimenstional array

			String[] Line_input_arr=Line_input.split(" ");

//Sets command equal to Line_input_arr[0]

			String command=Line_input_arr[0];
			if(command.equals("MakeAnLoan")||command.equals("ReturnAnItem")){
			for(int i=0; i<1;i++){

//If command is MakeAnLoan then the if statment is enforced

			if(command.equals("MakeAnLoan")){

//Make sure that Line_input_arr.length is not more or less than 5.
			if(Line_input_arr.length<5){
				System.out.println("Error: Please provide the customer's id, first name, last name, and the item's name.");
				System.out.println("Unsuccessful!");

//breaks if it is unsuccessful

				break;
			}
			if(Line_input_arr.length>5){
				System.out.println("Error: Please provide the customer's id, first name, last name, and the item's name.");
				System.out.println("Unsuccessful!");

//breaks if it is unsuccessful

				break;
			}

//declares Id as Line_input_arr[1]

				String ID = Line_input_arr[1];

//Validates ID and breaks if it does not meat the requirments

				isCustomerIdValid(ID);
				if(isCustomerIdValid(ID)==false){
					break;
				}

//Delcares first_name as Line_inpur_arr[2]

				String first_name = Line_input_arr[2];

//validates first_names

				isAlphabetic(first_name);

//breaks if the first name is invalid

				if(isAlphabetic(first_name)==-1){
					break;
				}


//Declares last_name as Line_input_arr[3]

				String last_name = Line_input_arr[3];

//Validates last_name

				isAlphabetic(last_name);

//breaks if the last name is invalid

				if(isAlphabetic(last_name)==-1){
					break;
				}

//check that the item exists


//Declares item as Line_input_arr[4]

				String item=Line_input_arr[4];

				if(indexItemInStock(stockArray, item)==-1){
					System.out.println(item+" is not a valid item in stock!");
					System.out.println("Unsuccsessful!");
//break if it doesn't 

					break;
				}

//if item is two words it cconcatinates the words with a space in between

				if(Line_input_arr.length==6){
					item = Line_input_arr[4]+" "+Line_input_arr[5];
				}

//validates item

				isValidItem(item, stockArray);

//Declares row_index as the row where item is located on stockArray

				int row_index=indexItemInStock(stockArray, item);

//Creates the item_ID

				String item_ID=createItemCode(row_index, stockArray, item);
			
				if(item_ID.equals("-1")){

//break  if item is out of stock
	
						break;
				}

//Prompts user for date

				System.out.println("Enter the the date-out (MM-DD-YYYY)");

//Scan for the date

				String date_out= input.nextLine();

//Validates that the date isn't less than 10 characters

				if(date_out.length()<10){
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccsessful!");
//breaks if it is
					break;
				}

//declare char c_0 equal to the character at position 0 in the date string

				char c_0=date_out.charAt(0);

//Validating the characters

				if((c_0 >= '0' && c_0 <= '9')){
		
				}

//Display error message if it wasn't a number
//does that same thing for the proceding if and else statments

				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}		
				char c_1=date_out.charAt(1);
				if((c_1 >= '0' && c_1 <= '9')){
			
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_3=date_out.charAt(3);
				if((c_3 >= '0' && c_3 <= '9')){

				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!3");
					break;
				}			
				char c_4=date_out.charAt(4);
				if((c_4 >= '0' && c_4 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	

				char c_6=date_out.charAt(6);
				if((c_6 >= '0' && c_6 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_7=date_out.charAt(7);
				if((c_7 >= '0' && c_7 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_8=date_out.charAt(8);
				if((c_8 >= '0' && c_8 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_9=date_out.charAt(9);
				if((c_9 >= '0' && c_9 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}

//Validates that the string is not more than 10 characters
	
				if(date_out.length()>10){
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");

//breaks if it is

					break;
				}

//Prompts user to enter notes

				System.out.println("Do you want to add any note (type none for not adding notes)?");

//scans the notes

				String notes=input.nextLine();

//If none was entered the if statments converts the none statment to available which was the initialized value set

				if(notes.equals("none")){
					notes="available";
				}

//Verify that the there is still stock to be rented out

				if(stockArray[row_index][1].equals("0")){
					System.out.println("All stock is being loaned out");
					System.out.println("Unsuccessful!");

//break if there isn't stock

					break;
				}

//takes the amount of an item in stock and subtracts one from it

				int temp_int =Integer.parseInt(stockArray[row_index][1]);
				int temp_int_minus_1=(temp_int-1);
				stockArray[row_index][1]=Integer.toString(temp_int_minus_1);

//declare loan_index equal to getNumLoans(loanArray)

				int loan_index=getNumLoans(loanArray);

				if(loan_index==-1){

//if loanArray is full break
					break;
				}

//fill the next available space in loanArray witht the values collected

				loan_filler(first_name, last_name, ID, item, item_ID, loanArray, date_out, notes, loan_index);

//finalize MakeAnLoan

				MakeAnLoan(row_index, stockArray);
			}
			}

//This for loop is for 1 loop and basically it is here becuase if someone makes a mistake it will break this for loop and redirect them back to the prompt to enter a command

			for(int i=0; i<1;i++){

//If command is ReturnAnItem this if statment will be enforced

			if(command.equals("ReturnAnItem")){
			if(Line_input_arr.length<3){
				System.out.println("Error: Please provide the customer's id and the item's name.");
				System.out.println("Unsuccessful!");

//breaks if it is unsuccessful

				break;

			}
			if(Line_input_arr.length>3){
				System.out.println("Error: Please provide the customer's id and the item's name.");
				System.out.println("Unsuccessful!");

//breaks if it is unsuccessful

				break;
			}

//Declares ID as Line_input_arr[1]

				String ID = Line_input_arr[1];

//Validates the ID with the one in loanArray

				isCustomerIdValid(ID);
				if(isCustomerIdValid(ID)==false){

//breaks if ID is not correct

					break;
				}

//Declares item_ID as Line_input_arr[2]

				String item_ID = Line_input_arr[2];

//Validates item_ID with the ones in loanArray

				itemIdCheck(loanArray, item_ID);
				if(itemIdCheck(loanArray, item_ID)==-1){

//breaks if item_ID isincorrect

					break;
				}

//Prompts user to enter the date and scans

				System.out.println("Enter the date in: ");
				String date_in=input.next();

//checks if the date is less than 10 charecters

				if(date_in.length()<10){
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");

//breaks if the string is less that 10 charecters

					break;
				}

//declare char c_0 equal to the charecter at position 0 in the date string

				char c_0=date_in.charAt(0);

//Validating the charecters

				if((c_0 >= '0' && c_0 <= '9')){
		
				}

//Display error message if it wasn't a number

				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");

//breaks if it was inputed wrong
//does that same thing for the proceding if and else statments

					break;
				}		
				char c_1=date_in.charAt(1);
				if((c_1 >= '0' && c_1 <= '9')){
			
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_3=date_in.charAt(3);
				if((c_3 >= '0' && c_3 <= '9')){

				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}			
				char c_4=date_in.charAt(4);
				if((c_4 >= '0' && c_4 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}
				char c_6=date_in.charAt(6);
				if((c_6 >= '0' && c_6 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_7=date_in.charAt(7);
				if((c_7 >= '0' && c_7 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_8=date_in.charAt(8);
				if((c_8 >= '0' && c_8 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	
				char c_9=date_in.charAt(9);
				if((c_9 >= '0' && c_9 <= '9')){
		
				}
				else{
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");
					break;
				}	

//Validates that the string is not more than 10 characters

				if(date_in.length()>10){
					System.out.println("The date is incorrectly written");
					System.out.println("Unsuccessful!");

//breaks if it is

					break;
				}

//record date_in into loanArray where the information was collected from MakeAnLoan

				int return_record=returnRecord(loanArray, ID);

//Declares loanArray at row return_recors and column 6 as the value of date_in

				loanArray[return_record][6]=date_in;

//Declares row_index as that value returned from itemIdCheck

				int row_index_n=itemIdCheck(loanArray, item_ID);

//Prompts the user to add notes and scans for them

				System.out.println("Do you want to add any note (type none for not adding notes)?");

//I dont know why but the becuase of the change from input.next() to input.nextLine(), the first instance of input.nextLine gets skipped so i had to create a useless input.nextLine so that the scan for notes didnt get skipped
				
				String wont_work=input.nextLine();

//Scans for notes1

				String notes1 =input.nextLine();

//Checks if notes1 is equal to none. It replaces none with available if it is.

				if(notes1.equals("none")){
					notes1="available";
				}

//if loanArray[row_index_n][7] is available it is replaced with whatever notes1 is

				if(loanArray[row_index_n][7].equals("available")){
					loanArray[row_index_n][7]=notes1;
				}

//if it isnt then the loanArray[row_index_n][7] and notes1 are concatinated together with a space in between
				else{
					loanArray[row_index_n][7]=loanArray[row_index_n][7]+"-"+notes1;	
				}

//Declares item as the item in loanArray

				String item=loanArray[row_index_n][4];

//finds the item in Stock Array

				int row_index=indexItemInStock(stockArray, item);

//Verify that not all the of the items being returned is already stocked

				if(stockArray[row_index][1].equals("5")){
					System.out.println("All of those items are already stocked");
					System.out.println("Unsuccessful!");

//breaks if they are

					break;
				}

//Adds 1 to the item amount

				int temp_int =Integer.parseInt(stockArray[row_index][1]);
				int temp_int_plus_1=(temp_int+1);
				stockArray[row_index][1]=Integer.toString(temp_int_plus_1);

//Prints the command was successful

				System.out.println("Succssess!");

			}
			}
			}

//Prints loanArray

			else if(command.equals("DisplayLoans")){
				DisplayLoans(loanArray);

			}

//Prints stockArray

			else if(command.equals("DisplayItems")){
				DisplayItems(stockArray);
			}

//Breaks the while loop so the prompt to enter command stops

			else if(command.equals("Quit")){
				break;
			}

//of the command was entered wrong this prints and error

			else{
				System.out.println("Enter a valid augment!");	
			}
		}
	}
}
