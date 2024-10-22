import java.util.Scanner;

public class ConsoleApplication {
    public static void main(String[] args) {
        displayIntro();
		displayMenu();
		subMenu();

    }

    public static void displayIntro() {
		
		String[] teamMembers= {
				
		"*******************",
		"*     GROUP19     *",
		"*   SELIN BUDAK   *",
		"* TUGBA CAGLAGONUL*",
		"*   BEYZA AKIN    *",
		"* BERKAY KARATAS  *",
		"* FURKAN KAPUSUZ  *",
		"*******************"
				
		};

        
        String[] smileyFace= {
           "            ",
           "|||||||||||",
           "|  _   _  |",
           "|  o   o  |",
           "| \\_____/ |",
           "\\_________/",
   


   };

        String[] welcomeMessage= {
        "__      _____ _    ___ ___  __  __ ___",
        "\\ \\    / / __| |  /  _/ _ \\|  \\/  | __|",
        " \\ \\/\\/ /| _|| |_ | (_|(_) | |\\/| | _| ",
        "  \\_/\\_/ |___|____\\___\\___/|_|  |_|___|",
            
        };

        int maxLength= Math.max(teamMembers.length,smileyFace.length);
		

		for(int i=0;i<maxLength;i++) 
		{
			String firstPattern= (i<teamMembers.length) ? teamMembers[i] : "";
			String secondPattern= (i<smileyFace.length) ? smileyFace[i] : "";
            System.out.printf("%s   %s%n",firstPattern,secondPattern);

        }
      
        for (String message : welcomeMessage) {
            System.out.printf("%s%n", message);
        }
	
	}
	
	public static void displayMenu() {
		boolean operationResult=true;
		String operation="";
		System.out.println("\nMENU");
		Scanner input=new Scanner(System.in);
		
		System.out.println(
				  " [A] Statistical Information about an array,\n"
				+ " [B] Matrix Operations,\n"
				+ " [C] Text Encryption/Decryption,\n"
				+ " [D] Tic-tac-toe HotSeat,\n"
				+ " [E] Terminate.\n");
		

		do {

			if(!operationResult){
				System.out.print("Please enter a valid operation character:");

			}else{
				System.out.print("Select the action you want to perform:");
			}
			operation =input.nextLine();
			operationResult= ((operation.equals("A")) || (operation.equals("B")) || (operation.equals("C")) || (operation.equals("D")) ||(operation.equals("E")));
			
		} while (!operationResult);


		switch (operation) {
			case "A":
				optionA();
				break;
			case "B":
				optionB();
				break;
			case "C":
				optionC();
				break;

			case "D":
				optionD();
				break;
			case "E":
				optionE();
				break;

			default:
				//burası dolacak
		}

		
		
	}
	
		public static void subMenu() {
		boolean operationResult=true;
		String operation2="";
		System.out.println("\nMENU");
		Scanner input2=new Scanner(System.in);
		
		System.out.println(
				  " [A] Transpose,\n"
				+ " [B] Inverse,\n"
				+ " [C] Matrix Multiplication,\n"
				+ " [D] Element-wise Multiplication,\n"
				+ " [E]  Return to the Main Menu.\n");
		

		do {

			if(!operationResult){
				System.out.print("s:Please enter a valid operation character:");

			}else{
				System.out.print("Select the action you want to perform:");
			}
			operation2 =input2.nextLine();
			operationResult= ((operation2.equals("A")) || (operation2.equals("B")) || (operation2.equals("C")) || (operation2.equals("D")) ||(operation2.equals("E")));
			
		} while (!operationResult);


		switch (operation2) {
			case "A":
				transpose();
				break;
			case "B":
				inverse();
				break;
			case "C":
				matrixMultiplation();
				break;

			case "D":
			    element_wiseMultiplication();
				break;
			case "E":
				returnMenu();
				break;

			default:
		
		}

	}	

	public static void transpose() {
		

        Scanner input3 = new Scanner(System.in);

        //part1: get valid rows.
        int rows;
        do {
            System.out.print("Please enter a valid rows number:");
            while (!input3.hasNextInt()) { // to use for positive number (valid number)
                System.out.println("Invalid input please enter a number:");
                input3.next(); // delete invalid input.
            }
            rows = input3.nextInt();
        } while (rows <= 0); // check positive number

        // part2: get valid columns.
        int columns;
        do {
            System.out.print("Please enter a valid columns number:");
            while (!input3.hasNextInt()) { // valid integer number control.
                System.out.println("Invalid input please enter a number:");
                scanner.next(); // Geçersiz girdiyi temizler
            }
            columns = input3.nextInt();
        } while (columns <= 0); // check positive number

        // part3: do matrix
        
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean validInput = false;
                do {
                    System.out.print("Enter  [" + i + "][" + j + "] values: ");
                    if (scanner.hasNextInt()) { // check enter a valid input or not.
                        matrix[i][j] = input3.nextInt();
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter a positive integer number:");
                        input3.next(); // delete invalid input
                    }
                } while (!validInput); // it continue to enter valid input.
            }
        }

        //part4: print users matrix
        System.out.println("Yours matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
		//part5: do transpose
		int[][] transposeMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
		//print transpose matrix
        System.out.println("Transpose matrix:");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }

        input3.close();
    }
}
        

		


               

  
		
	

	
	public static void inverse() {

        //
	}

	public static void matrixMultiplation() {
      //

	}

	public static void element_wiseMultiplication() {
		//
	}

	public static void returnMenu(){
         //
	}

	
//--------------------------------------------------------------------------------------------
	public static void optionA() {

	}

	
	public static void optionB() {

      subMenu();
	}

	public static void optionC() {}


	
	public static void optionD() {
		char[][] board= {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
		printGameBoard(board);




	}

	public static void printGameBoard(char board[][]){

		System.out.println("-------------"); 
		for (int i = 0; i < 3; i++) //iterates rows
   		 {
			for (int j = 0; j < 3; j++) //iterates columns
			{
				System.out.printf("| %c ", board[i][j]);
			}
        	System.out.print("|\n");
    	}

    	System.out.println("-------------"); 

	}

	public static void optionE() {}

	




    
}
