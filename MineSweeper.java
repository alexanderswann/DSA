import java.util.Scanner;
import java.util.Random;
public class MineSweeper{
public static void main(String[] args){
		int x = 0;
		Scanner scan = new Scanner(System.in);

		System.out.println("Dimensions?\n");
		String number = scan.nextLine();

		int int1 = Integer.parseInt(number);
      
      	System.out.println("\nNum of Bombs?\n");
		String number2 = scan.nextLine();

		int numBombs = Integer.parseInt(number2);


		String[][] Board = new String[int1][int1];



		while(x < numBombs){
			
			Board[(int)(Math.random() * (int1))][(int)(Math.random() * (int1))] = "*";

			x = NumBombs(int1, Board);

		}

      
      System.out.println(printBoard(int1, Board));        
      

		


	}
   
	public static int NumBombs(int int1, String[][] Board){
		int x = 0;
		for (int i = 0; i < int1; i++) {
				for (int j = 0; j < int1 ; j++) {
					if(Board[i][j]==null){
						x++;
					}
				}
		}
		return (int1 * int1) - x;
	}
   
   public static String printBoard(int int1, String[][] Board){
      String tp = "";
      
		for (int i = 0; i < int1; i++) {
         for(int ij = 0; ij< int1; ij++){
            tp += "  - ";
         }
         
            tp += "\n| ";
            
				for (int j = 0; j < int1 ; j++) {
					if(Board[i][j]==null){
						tp += "  | ";
					}else{
                  tp += "* | ";
               }
				}
            
            tp += "\n";
		}
      
      for(int ij = 0; ij< int1; ij++){
            tp += "  - ";
         }
      
      
      return tp;
      
   }
   

   
   
}
