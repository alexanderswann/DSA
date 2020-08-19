import java.util.Scanner;
import java.io.*;
public class gift1{
	public static void main(String[] args){
		try {
		Scanner scan = new Scanner(new File("gift1.in"));
		int numppl = Integer.parseInt(scan.nextLine());

		String[] ppl = new String[numppl];

		for (int i = 0;i < numppl; i++) {
			ppl[i] = scan.nextLine();
		}
		System.out.println(ppl[numppl-1]);

		
	}
	catch(IOException e){
		System.out.println("SOmething went wrong");
	}

	}

	public static int ind(String name){

	}

}