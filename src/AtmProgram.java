////////////////////////////////ATM////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;



public class AtmProgram {
	
	/* Global Variables*/
	String ID = "";
	String pin = "";
	String AccBalance = "";
	
	
	


	////////////////////////////////DEFAULT CONSTRUCTOR////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	public AtmProgram () { 
		Welcome();
		Login();
		Menu();
		}

////////////////////////////////WELCOME/////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
		public void Welcome () {
	System.out.println("Hello..");                                   /* Welcome Message */
	System.out.print("Please type in your I.D. Account: ");
}

////////////////////////////////LOGIN////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////
		public String Login() {
			String AccountNumber = "";
			String Password = "";
		Boolean flag = false;
		
		         /* Getting Input from User*/
		do {
			AccountNumber = BufferedReaderInput ();
			if((AccountNumber.length() >= 8) && (AccountNumber.length() < 9) && (AccountNumber.matches("[0-9]+"))){
			flag = true;
			} else {	          /* Verifying Input Account Length */
				System.out.print("try it again, type in your 8 digits account number: ");
				flag = false;
			}
		}while (flag == false);
		
			do {
				flag = false;
				System.out.print("Introduce password: ");
				Password = BufferedReaderInput ();        /* Verifying Input Password Length*/
				if((Password.length() >= 4) && (Password.length() < 5) && (Password.matches("[0-9]+"))){
				flag = true;
				} else {
					System.out.print("try it again type in your 4 digits password: ");
					flag = false;
				}
			}while (flag == false);
			ID = AccountNumber;
			
			try {
				 /* Reading Account to get User Information*/
				BufferedReader br = new BufferedReader (new FileReader("/Users/juanvelasquez/Desktop/BankAccounts/"+ID+".txt"));
				String IDLocal = br.readLine();
				String pinLocal = br.readLine();
				String AccBalanceLocal = br.readLine();
				
				ID = IDLocal;
				pin = pinLocal;
				AccBalance = AccBalanceLocal;
				 /* Match Verifying with  User Information with User Input*/
				if (ID.equals(ID) && Password.equals(pin)) {
					
					
				} else {
					System.out.print("The password or Account didnt match try it again: ");
						Login();    /* Send back to Login if Input did not match*/
					}
				
				br.close();
				} catch(Exception e) {
					System.out.println("Your Account Number dont match");
					System.out.println("Try it again");
					Login();
					}
		
			return AccountNumber;
		}
		
				
			
			
	
////////////////////////////////MENU////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void Menu () {
		String MenuString = "";
		Boolean flag = false;
		 /* Printing Screen Menu*/
		System.out.println("1.- Check the current account balance     4.- Stock Value");
		System.out.println("2.- Withdraw money                        5.- Logout");
		System.out.println("3.- Change the password                   6.- Bank Summary");
		
		System.out.print("            Please enter one option: ");
		 /* Reading Input from user*/
		do {
			MenuString = BufferedReaderInput (); /* Verifying Input from User*/
			if((MenuString.length() >= 1) && (MenuString.matches("[0-6]+"))){
			flag = true;
			} else {
				System.out.print("Type a correct option: ");
				flag = false;
			}
		}while (flag == false);
		 /* Addressing User Selection*/
		if(MenuString.equals("1")) {	
			AccountBalance (AccBalance);
			YN ();
		}
		else if(MenuString.equals("2")) {
			WithrawMoney (AccBalance);
		}
		else if(MenuString.equals("3")) {
			ChangePassword (pin);
		}
		else if(MenuString.equals("4")) {
			StockValue ();
		}
		else if (MenuString.equals("5")) {
			LogOut ();
}
		else if (MenuString.equals("6")) {
			BankSummary ();
}
	}
	
////////////////////////////////ACOUNT BALANCE////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 /* Checking for Account Balance*/
	public void AccountBalance (String AccBalance) {
		System.out.print("Your Current Balance is: ");
		System.out.println(AccBalance);
	}
	

////////////////////////////////WITHRAW MONEY///////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void WithrawMoney (String AccBalance) {
		
		 /* Modifying Global Variable to Integer (so it can be calculated)*/
		int pinInt = Integer.parseInt(pin);
		 /* Modifying Global Variable to Double (so it can be printed in decimals)*/
		Double AccBalancedob = Double.valueOf(AccBalance);
		Integer Withraw = 0;
		String MenuString = "";
		 /* Printing on the screen Withdraw Options*/
		System.out.println("How much would you like to withraw?");
		System.out.println("1.- 100                            2.-50");
		System.out.println("3.- 20                             4.-10");
		System.out.println("5.- Other Amount");
		MenuString = BufferedReaderInput ();
		
		 /* Addressing Input User Selection*/
		
		
			if(MenuString.equals("1")) {
			Withraw = 100;
			if((Withraw <= AccBalancedob)){
			WrittingAccount (Withraw, pinInt);
			YN();
					}	else {  /* Checking User has On Bank Account the Selected Amount*/
						System.out.println("Sorry you have not enough founds");
						YN();  }
			}
			
			else if(MenuString.equals("2")) {
			Withraw = 50;
			if((Withraw <= AccBalancedob)){
			WrittingAccount (Withraw, pinInt);
			YN();
					}	else { /* Checking User has On Bank Account the Selected Amount*/
						System.out.println("Sorry you have not enough founds");
						YN();  }
			}
			else if(MenuString.equals("3")) {
			Withraw = 20;
			if((Withraw <= AccBalancedob)){
			WrittingAccount (Withraw, pinInt);
			YN();
					}	else { /* Checking User has On Bank Account the Selected Amount*/
						System.out.println("Sorry you have not enough founds");
						YN();  }
			}
			else if (MenuString.equals("4")) {
			Withraw = 10;
			if((Withraw <= AccBalancedob)){
			WrittingAccount (Withraw, pinInt);
			YN();
					}	else { /* Checking User has On Bank Account the Selected Amount*/
						System.out.println("Sorry you have not enough founds");
						YN();  }
			}
			else if (MenuString.equals("5")) {
			Boolean flag = false;
			do {		/* Reading Input from User*/
			System.out.print("Type in the amount you would like to withraw: ");
			String WithrawString = Integer.toString(Withraw);
			WithrawString = BufferedReaderInput ();
			Withraw = Integer.parseInt(WithrawString); 
			/* The ATM Can Just Display 10,20,50 (Euro Notes)*/
			if((Withraw % 10) == 0 || (Withraw % 50) == 0){
				/* The Maximum Amount for withdraws is 400 euro*/
				if((Withraw <= 400)){
					/* The User Must Have The Amount Available In the Bank*/
					if((Withraw <= AccBalancedob)){
						flag = true;
						WrittingAccount (Withraw, pinInt);
						YN(); }
					 else {
					System.out.println("Insuficient Funds");
					flag = false; } }
				  else {
					System.out.println("The amount can not exceed 400");
					flag = false;
				 } }
			 else {
				System.out.println("Please enter a correct amount");
				flag = false;
			}
			}while (flag == false);
		}
		} 
		
	
////////////////////////////////CAHNGE PASSWORD////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void ChangePassword (String pin) {
		/* Creating Variables*/
		Boolean flag = false;
		String NewPassword = "";
		String NewPassword2 = "";
		String CurrentPassword = "";
		
		
		/* Getting Input from User (Current Password)*/
		System.out.print("Please type in your current password: ");
		CurrentPassword = BufferedReaderInput ();
		/* Checking if it is Current Password)*/
		if (CurrentPassword.equals(pin)){
			
			/* Getting Input from User (New Password)*/
		do {
			System.out.print("Please Introduce your 4 digist new password: ");
			NewPassword = BufferedReaderInput ();
			if((NewPassword.length() >= 4) && (NewPassword.length() < 5) && (NewPassword.matches("[0-9]+"))){
			flag = true;
			} else {
				System.out.println("try it again, type in your 4 digits password");
				flag = false;
			}
		}while (flag == false);
		
		System.out.print("Type in again your new password: ");
		/* Getting Input from User (Current Password) 2nd Time*/
		do {
			NewPassword2 = BufferedReaderInput ();
			if((NewPassword2.length() >= 4) && (NewPassword2.length() < 5) && (NewPassword2.matches("[0-9]+"))){
			flag = true;
			} else {
				System.out.println("try it again, type in your 4 digits password");
				flag = false;
			}
		}while (flag == false);
		/* Checking if the two new passwords match*/
		if (NewPassword.equals(NewPassword2)) {
			int NewPasswordInt = Integer.parseInt(NewPassword);
			int Withraw = 0;
			WrittingAccount (Withraw, NewPasswordInt);
			YN ();
		}
		else { /* Addressing back to Change Password Option*/
			System.out.println("The password didnt match try it again ");
			ChangePassword (pin);
		}
		}else { /* Logging out from system if the Current Password do not match*/
			System.out.println("your password is incorrect take your card ");
		}
	}
	
////////////////////////////////BANK SUMMARY//////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
	
	public void BankSummary () {
		
		/* Variables*/
		Double TotalAccounts = 0.0;
		String Account1 = "11111111";
		String Balance1 = "";
		String Account2 = "22222222";
		String Balance2 = "";
		String Account3 = "33333333";
		String Balance3 = "";
			String IDLocal = "";
			String PinLocal = "";
			
			/* Reading Account Number 1*/
		try {
			
			BufferedReader br = new BufferedReader (new FileReader("/Users/juanvelasquez/Desktop/BankAccounts/"+Account1+".txt"));
			IDLocal = br.readLine();
			PinLocal = br.readLine();
			Balance1 = br.readLine();
			
			
			
			br.close();
			} catch(Exception e) {System.out.println("File error");}
				
		
		/* Reading Account Number 2*/
		try {
			
			BufferedReader br = new BufferedReader (new FileReader("/Users/juanvelasquez/Desktop/BankAccounts/"+Account2+".txt"));
			IDLocal = br.readLine();
			PinLocal = br.readLine();
			Balance2 = br.readLine();
			
			
			
			br.close();
			} catch(Exception e) {System.out.println("File error");}
				
		/* Reading Account Number 3*/
		try {
			
			BufferedReader br = new BufferedReader (new FileReader("/Users/juanvelasquez/Desktop/BankAccounts/"+Account3+".txt"));
			IDLocal = br.readLine();
			PinLocal = br.readLine();
			Balance3 = br.readLine();
			
			
			
			br.close();
			} catch(Exception e) {System.out.println("File error");}
		/* Changing Variables from String To Integer*/
				Integer Account1dob = Integer.valueOf(Account1);
				Integer Account2dob = Integer.valueOf(Account2);
				Integer Account3dob = Integer.valueOf(Account3);
				
				Double Balance1dob = Double.valueOf(Balance1);
				Double Balance2dob = Double.valueOf(Balance2);
				Double Balance3dob = Double.valueOf(Balance3);
				
				
				String Class = "";
				
				
				
				
				
					Integer classa = 0;
					Integer classb = 0;
					Integer classc = 0;
					Integer classd = 0;
					/* Calculating Total Balance in the Bank*/
				TotalAccounts = Balance1dob + Balance2dob + Balance3dob;
				System.out.print("The total amount stored in the bank is of: ");
				System.out.println(TotalAccounts);
				/* Classifying Accounts*/
				Class = ClasifAccounts (Account1dob, Balance1dob);
				if (Class.equals("a")) {
					classa = classa + 1;
				}
				else if (Class.equals("b")) {
					classb = classb + 1;
				}
				else if (Class.equals("c")) {
					classc = classc + 1;
				}
				else if (Class.equals("d")) {
					classd = classd + 1;
				}
				Class = ClasifAccounts (Account2dob, Balance2dob);
				if (Class.equals("a")) {
					classa = classa + 1;
				}
				else if (Class.equals("b")) {
					classb = classb + 1;
				}
				else if (Class.equals("c")) {
					classc = classc + 1;
				}
				else if (Class.equals("d")) {
					classd = classd + 1;
				}
				Class = ClasifAccounts (Account3dob, Balance3dob);
				if (Class.equals("a")) {
					classa = classa + 1;
				}
				else if (Class.equals("b")) {
					classb = classb + 1;
				}
				else if (Class.equals("c")) {
					classc = classc + 1;
				}
				else if (Class.equals("d")) {
					classd = classd + 1;
					/* Printing Screen*/
				}
				System.out.println("(" + classa + ") ....... Is The number of small accounts in the bank");
				System.out.println("(" + classb + ") ....... Is The number of medium accounts in the bank");
				System.out.println("(" + classc + ") ....... Is The number of large accounts in the bank");
				System.out.println("(" + classd + ") ....... Is The number of extra large accounts in the bank");
	}

///////////////////////////////ClASSIFYING ACCOUNTS//////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

	public String ClasifAccounts (Integer Account, Double Balance) {
		
		String Class = "";
		
		/* Checking Accounts Under €100 */
		if (Balance <= 100 ) {
			Class = "a";
			
			System.out.println("The Account: " + Account + "  is located in the small group");
		}
		/* Checking Accounts from €100 up to €200*/
		else if (Balance > 100 && Balance <= 200) {
			Class = "b";
			
			System.out.println("The Account: " + Account + "  is located in the medium group");
		}
		/* Checking Accounts from €200 up to €300 */
		else if (Balance > 200 && Balance <= 300) {
			Class = "c";
		
			System.out.println("The Account: " + Account + "  is located in the large group");
		}
		/* Checking Accounts from €300 */
		else if (Balance > 300) {
			Class = "d";
			
			System.out.println("The Account: " + Account + "  is located in the extra large group");
			
			
		}
		
		return Class;
	}
	
////////////////////////////////LOG OUT///////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

	public void LogOut () {
	System.out.println("Thank You");
	System.out.println("Take your Card and Cash");
}
	
////////////////////////////////BUFFER READER////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String BufferedReaderInput () {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			String BufferInput = "";
		try {
			BufferInput = br.readLine();
		} catch (Exception e) {}
		return BufferInput;
	}

////////////////////////////////YES AND NO////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void YN (){
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String BufferInput = "";
		try {
			Boolean flag = false;
			System.out.println("Would you like to do Another transaction?");
		do {
			System.out.print ("Please enter Yes or No: ");
			BufferInput = br.readLine();
			BufferInput = BufferInput.toUpperCase();
			/* Validation */
			if(BufferInput.equals("Y") || BufferInput.equals("N")) {
				flag = true;
			} else {flag = false;}
			} while (flag == false);
			
		} catch (Exception e) {}
		

		if(BufferInput.equals("Y")){
			Menu();
		}else if (BufferInput.equals("N")){
			System.out.println("Please Take Your Card");}
		
	}
			
	
////////////////////////////////WRITTING ACOUNT////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
public void WrittingAccount (Integer Withraw, Integer NewPassword) {

	Double AccBalancedob = Double.valueOf(AccBalance);
	int NewPasswordInt = Integer.parseInt(pin);

	NewPasswordInt = NewPassword;
	AccBalancedob = AccBalancedob - Withraw;
		/* Reading Account*/
	try {
			PrintWriter writer = new PrintWriter("/Users/juanvelasquez/Desktop/BankAccounts/"+ID+".txt");
			writer.println(ID);
			writer.println(NewPasswordInt);
			writer.println(AccBalancedob);

			AccBalance = Double.toString(AccBalancedob);	
			pin = Integer.toString(NewPasswordInt);


			writer.close(); 
			
		} catch (Exception e) {	e.printStackTrace(); System.out.println("Writting error"); }
	
}

////////////////////////////////STOCK VALUE////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////

public void StockValue () {
	
		String [] List = new String [100];
	
		/* Reading Stock Value */
			try {
				BufferedReader br = new BufferedReader (new FileReader("/Users/juanvelasquez/Desktop/BankAccounts/StockValue.txt"));
				 int i = 0;
				 String Line = br.readLine();
				 	while (Line != null) {
				 		System.out.println(Line);
				 		Line = br.readLine();
				 		List [i] = Line;
				 		i++; }
				 		br.close();
			} catch (Exception e) { System.out.println("File error"); }
			
			YN ();
	
}
			
			
			

		
		
	
///////////////////////////////////MAIN METHOD////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[]args) {
	new AtmProgram();
}
}


