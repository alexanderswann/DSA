import java.util.Scanner;

public class Pythagorean{
public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first number\n");
		String number = scan.nextLine();
		

		System.out.println("Enter your second number\n");
		String number2 = scan.nextLine();


		int int1 = Integer.parseInt(number);
		int int2 = Integer.parseInt(number2);

		System.out.println(Math.sqrt((int1*int1)+(int2*int2)));

	}
}