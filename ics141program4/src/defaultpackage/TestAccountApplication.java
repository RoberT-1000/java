import javax.swing.*;
import java.text.NumberFormat;
 
public class TestAccountApplication {
 
    public static void main(String[] args) throws java.io.IOException {
        String strName, strType, strAmt;
        double amount;
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
        char choice, ignore;
        Object[] objArray = new Object[4];
        int i = 0, index = 0;
		
        for(;;) {
			      do {
			            System.out.println("Personal Banking System Menu");
			            System.out.println("Make a Selection on: \n");
						
			            System.out.println("	1. Create a checking account");
			            System.out.println("	2. Create a savings account");
			            System.out.println("	3. Deposit Money");
			            System.out.println("	4. Get balance");
			            System.out.println("	5. Withdraw Money");
			            System.out.println("	6. Get yearend balance");
			            System.out.println();
						
			            System.out.println("Choose one (q to quit): ");
						
			            choice = (char) System.in.read();
						
			            // the effect of following do-while loop is to delay the processing
			            // until the user hits a return (then throw away all the characters 
			            // except the first one).
			            do {
		                  ignore = (char) System.in.read();
			            } while(ignore != '\n');
						
			            if(choice < '1' | choice > '6' & choice != 'q') {
			            	System.out.println("Invalid selection, Please choose again\n");
			            }	
			      } while(choice < '1' | choice > '6' & choice != 'q');
					
			      if(choice == 'q') {
			            System.out.println("Bye!");
			            break;
			      }
		 
			      System.out.println('\n');
					
			      switch(choice) {
			          case '1':
				            strName = JOptionPane.showInputDialog("Enter an account name:");
				            CheckingAccount cac = new CheckingAccount(strName, "checking", 0);
				            objArray[index++] = cac;
				            System.out.println("A new checking account is created and added to the system.");
				            break;
				        case '2':
				    		    strName = JOptionPane.showInputDialog("Enter an account name:");
				    		    SavingsAccount sac = new SavingsAccount(strName, "savings", 0);
				    		    objArray[index++] = sac;
				    		    System.out.println("A new savings account is created and added to the system.");
				    		    break;
				         case '3':
				             strType = JOptionPane.showInputDialog("Enter an account type (checking/savings):");
				             strName = JOptionPane.showInputDialog("Enter an account name:");
				             for(i=0; i<index; i++) {
				        	       if(((Account)objArray[i]).getType().equals(strType) && ((Account)objArray[i]).getName().equals(strName)) { 
				        		         strAmt = JOptionPane.showInputDialog("Enter the amount to deposit:");
				        		         double m = Double.parseDouble(strAmt);
				        		         ((Account)objArray[i]).deposit(m);
				        		         System.out.println(fmt1.format(m) + " is deposited into " + strName + " " + strType + " account");
				        		         break;
				        	       }
				             }
				             if(i == index) {
				                 System.out.println("No " + strType + " account for " + strName);
				             }
				             break;
				         case '4':
				             strType = JOptionPane.showInputDialog("Enter an account type (checking/savings):");
				             strName = JOptionPane.showInputDialog("Enter an account name:");
				             for(i=0; i<index; i++) {
				        	       if(((Account)objArray[i]).getType().equals(strType) && ((Account)objArray[i]).getName().equals(strName)) {
				        		         double bl = ((Account)objArray[i]).getBalance();
				        		         System.out.println("The balance for " + strName + " in " + strType + " is: " + fmt1.format(bl));
				        		         break;
				                 }
				             }
				             if(i == index) {
				                 System.out.println("No " + strType + " account for " + strName);
				             }
				             break;
				         case '5':
				             strType = JOptionPane.showInputDialog("Enter an account type (checking/savings):");
				             strName = JOptionPane.showInputDialog("Enter an account name:");
				             for(i=0; i<index; i++) {
				        	       if(((Account)objArray[i]).getType().equals(strType) && ((Account)objArray[i]).getName().equals(strName)) { 
				        		         strAmt = JOptionPane.showInputDialog("Enter the amount to withdraw:");
			       	        		   double m = Double.parseDouble(strAmt);
				              		   double x = ((Account)objArray[i]).withdraw(m);
				        		         System.out.println(fmt1.format(x) + " has been withdrawn from " + strName + " " + 
				        				         strType + " account" + " and the remaining balance is " + 
				        				         fmt1.format((((Account)objArray[i]).getBalance())));
				        		         break;
				        	       }
				             }
				             if(i == index) {
				                 System.out.println("No " + strType + " account for " + strName);
				             }
				             break;
				          case '6':
				    	        strType = JOptionPane.showInputDialog("Enter an account type (checking/savings):");
				    	        strName = JOptionPane.showInputDialog("Enter an account name:");
				    	        for(i=0; i<index; i++) {
				    		          if(((Account)objArray[i]).getType().equals(strType) && ((Account)objArray[i]).getName().equals(strName)) {
					    	  
				    		          }
				    	        }		 	      
			            }
			        }  
          }
      }
}
