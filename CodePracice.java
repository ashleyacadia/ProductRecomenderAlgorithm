package onlineShopApplication;

public class CodePracice {

	try
	{
	System.out.println("Enter a value for numerator: ");
	int numerator = scan.nextInt();
	System.out.println("Enter a value for denominator: ");
	int denominator = scan.nextInt();
	int result = numerator/denominator;
	System.out.println("The quotient "+numerator+" and "+denominator+" is: “+result);
	}catch(
	InputMismatchException inputMismatchException)
	{
		System.out.println("You must input integer values");
		System.err.println("Exceptional event: " + inputMismatchException);
		scan.next();// remove bad input from the scanner.
	}
}
