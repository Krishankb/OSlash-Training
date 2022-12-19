public class CarLoan {
	public static void main(String[] args) {

	int carloan = 10000;
	int loanLength = 3;
	int interestRate = 5;
	int downPayment = 2000;
	int remainingBalance ;
	int months,monthlyBalance,interest,monthlyPayment;
	if (loanLength <= 0){
	    System.out.println("Invalid Car loan length ");
	}
	else if (downPayment >= carloan) {
	    System.out.println("The car can be paid in full.");
	}
	
	else {
	    
	    remainingBalance = carloan - downPayment;
	    months = loanLength*12;
	monthlyBalance = remainingBalance/months; 
	interest = (monthlyBalance*interestRate) /100;
	monthlyPayment = monthlyBalance + interest;
	System.out.println(monthlyPayment);
	}
	
	
	
	
  

	}
}
