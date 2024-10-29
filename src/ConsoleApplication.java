
import java.util.Scanner;

public class ConsoleApplication {
    public static void main(String[] args) {
		
        displayIntro();
		displayMenu();
		

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

        int maxLength= maximum(teamMembers.length,smileyFace.length);
		

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
		Scanner input= new Scanner(System.in);
		
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
	
	public static int maximum(int x,int y) {
		int maximumValue=x;
		if(y>x) {
			maximumValue=y;
			
		}
		
		return maximumValue;
		
	}

	public static void optionA() {}


	public static void optionB() {
		subMenu();
	}

	public static void subMenu() {
		boolean operationResult=true;
		String operation2="";
		System.out.println("\n[B] MATRIX OPERATIONS");
		System.out.println("\nMENU");
		Scanner input2=new Scanner(System.in);
		
		System.out.println(
				  " [a] Transpose,\n"
				+ " [b] Inverse,\n"
				+ " [c] Matrix Multiplication,\n"
				+ " [d] Element-wise Multiplication,\n"
				+ " [e] Return to the Main Menu.\n");
		

		do {

			if(!operationResult){
				System.out.print("s:Please enter a valid operation character:");

			}else{
				System.out.print("Select the action you want to perform:");
			}
			operation2 =input2.nextLine();
			operationResult= ((operation2.equals("a")) || (operation2.equals("b")) || (operation2.equals("c")) || (operation2.equals("d")) ||(operation2.equals("e")));
			
		} while (!operationResult);


		switch (operation2) {
			case "a":
				transpose();
				break;
			case "b":
				inverse();
				break;
			case "c":
				matrixMultiplation();
				break;

			case "d":
			    element_wiseMultiplication();
				break;
			case "e":
				returnMenu();
				break;

			default:
		
		}

	}	



	public static void transpose() {
		

        Scanner input3 = new Scanner(System.in);
        boolean isAnswerValid=true;
        String answer="";
        int rows=0;
        int columns=0;
        do {
            try {
            	
	        	if(isAnswerValid==false) {
	        		System.out.println("Please enter a valid row number:");
	        		
	        	}
	        	else {
	        		System.out.println("Please enter the total number of rows as a positive integer:");
	        	}
	        	
	        	 answer=input3.nextLine();
	        	 rows= Integer.parseInt(answer);
	        	 
	        	 if(rows<=0) {
	        		 isAnswerValid=false;
	        		 
	        	 }else {
	        		 isAnswerValid=true;
	        	 }
	        	 
            	}catch(NumberFormatException e) {
            		System.out.println(e);
            		isAnswerValid=false;
            	
            	}
            
        } while (!isAnswerValid);
        
        

        do {
            try {
            	
	        	if(isAnswerValid==false) {
	        		System.out.println("Please enter a valid column number:");
	        		
	        	}
	        	else {
	        		System.out.println("Please enter the total number of columns as a positive integer:");
	        	}
	        	
	        	 answer=input3.nextLine();
	        	 columns= Integer.parseInt(answer);
	        	 
	        	 if(columns<=0) {
	        		 isAnswerValid=false;
	        		 
	        	 }else {
	        		 isAnswerValid=true;
	        	 }
	        	 
            	}catch(NumberFormatException e) {
            		System.out.println(e);
            		isAnswerValid=false;
            	
            	}
            
        } while (!isAnswerValid);
        
        
        
        boolean validInput = true;
        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
               
               do {
                	try {
                	 if (validInput==false) { 
                    	 System.out.println("Invalid input. Please enter a double number:");
                        
                     }else {
                    	 System.out.printf("Enter [%d][%d] values: ", i,j);
                     }
           
                     answer=input3.nextLine();
                	 matrix[i][j] = Double.parseDouble(answer);
                	 validInput=true;
                	
                	 }catch(NumberFormatException e) {
                		 System.out.println(e);
                		 validInput=false;
                	 }
              
                  } while (!validInput); 
             }
        }

        System.out.println("Your matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%10.2f\t",matrix[i][j]);
            }
            System.out.println();
        }
		
		double[][] transposeMatrix = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
		
        System.out.println("\nTranspose matrix:");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
            	System.out.printf("%10.2f\t",transposeMatrix[i][j]);
            }
            System.out.println();
        }
		
    }


	public static void inverse() {//--------------------------------------------------
/*
		//matris alınırken row ve column un değerinin aynı olup olmadığı kontrol edilecek eğer aynıysa hesaplanıcak yoksa tekrar değer istenecek.
		double[][] matrix = {};// matris alınacak.

        double determinant = calculateDeterminant(matrix);

        if (determinant != 0) {
            System.out.println("The determinant of the matrix is different from zero, its inverse can be calculated:");
        } else {
            System.out.println("The determinant of the matrix is zero, the inverse of the matrix cannot be calculated .");
        }
    }

    public static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            
            return matrix[0][0];
        }
        if (n == 2) {
        
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

		double determinant = 0;
		//devamında diğer değrler için hesaplanacak.

        //----------------------------------------------------------
	}
*/
	}
	public static void matrixMultiplation() {// burdaki eksiklik inputları harf olarakta girilebilirbunu engellemek lazım.
      //-------------------------------------------
	  

        Scanner input5 = new Scanner(System.in);
        int m1, n1, m2, n2;


        while (true) {
            System.out.print("Please enter a first matrix row:");
            m1 = input5.nextInt();
            System.out.print("Please enter a first matrix columns:");
            n1 = input5.nextInt();

            System.out.print("Please enter a second matrix row:");
            m2 = input5.nextInt();
            System.out.print("Please enter a second matrix columns:");
            n2 = input5.nextInt();

            // check inputs for square matrix
            if (n1 == m2) {
                break;
            } else {
                System.out.println("Please valid input.First matrix columns must equal second matrix rows input. Try again:");
            }
        }

        int[][] matrixA = new int[m1][n1];
        int[][] matrixB = new int[m2][n2];

        // get first matrixs value
        System.out.println("Please enter first matrix values:");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                System.out.print("matrixA[" + i + "][" + j + "] = ");
                matrixA[i][j] = input5.nextInt();
            }
        }

        // get second matrix value.
        System.out.println("Please enter second matrix values:");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print("matrixB[" + i + "][" + j + "] = ");
                matrixB[i][j] = input5.nextInt();
            }
        }


        // calculation multiply
        int[][] result = multiplyMatrices(matrixA, matrixB);

        // print result on the screen 
        System.out.println("Calculated matrix result:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
		displayMenu();
	}

    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int m = mat1.length;          // first matrixs rows value
        int n = mat1[0].length;       // first matrixs columns value
        int p = mat2[0].length;       // second matrixs columns value

        int[][] result = new int[m][p];

        //matrix multiplying 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return result;

}

	  //---------------------------------------

	

	public static void element_wiseMultiplication() {//------------------------------------------
		
		Scanner input6 = new Scanner(System.in);
        int r, c;

		


        while (true) {
            System.out.print("Please enter a matrixs number of rows :");
            r = input6.nextInt();
            System.out.print("Please enter a matrixs number of columns:");
            c = input6.nextInt();
			int[][] matrixA = new int[r][c];
       		int[][] matrixB = new int[r][c];
			int[][] matrixR = new int[r][c];


            //get first matrix values by user
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					System.out.print("Please enter a first matrix [" + i + "][" + j + "] = ");
					matrixA[i][j] = input6.nextInt();
				}												
			}
            // get second matrix values by user
            for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					System.out.print("Please enter a second matrix [" + i + "][" + j + "] = ");
					matrixB[i][j] = input6.nextInt();
				}												
			}
			
			
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					matrixR[i][j] = matrixA[i][j]*matrixB[i][j];
				}
			}
			System.out.print("Element-wise multiplication:"+ " \n");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(matrixR[i][j] + " ");
            
				}
				System.out.print("\n");
			}
			displayMenu();
		}
}//--------------------------------------


	public static void returnMenu(){
         displayMenu();
	}





	public static void optionC() {}

	public static void optionD() {
		char[][] board= {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
		String[]playerNames= new String[2];
		Scanner input=new Scanner(System.in);
		int currentPlayer=1;
		int turns=0;
		boolean hasWinner=false;
		boolean isDraw=false;

		
		System.out.printf("%nWelcome to Tic Tac Toe HotSeat!%n");
		for(int i=0;i<2;i++){
			System.out.printf("Enter the player %d's name:",i+1);
			String player_name=input.nextLine();
			playerNames[i]= player_name=="" ? String.format("Player %d",i+1) : player_name;
		
		}

		printGameBoard(board);
		
		while(!hasWinner) {
			int choice= getChoice(playerNames[currentPlayer-1]);
			char symbol=getSymbol(currentPlayer);
			if(moveValidation(board,choice)==1) {
				playGame(board,choice,symbol);
				turns++;
				if(gameWinCheck(board,symbol)==true) {
					
					hasWinner=true;
					break;
				}
				currentPlayer=changePlayer(currentPlayer);
				getSymbol(currentPlayer);
			}
			else {
				System.out.println("Invalid move. Please try again"); 
			}
			if(turns==9) {
				isDraw=true;
				break;
			}
			
			printGameBoard(board);
			
			
		}
		
		if(hasWinner==true) {
			printGameBoard(board);
			displayLeader(playerNames, currentPlayer,turns);
			
			
		}
		
		if(isDraw==true) {
			printGameBoard(board);
			displayDrawMessage(turns);
			
		}
		
		int isRestarted= replayGame();
		if(isRestarted==1) {
			optionD();
		}
		else if(isRestarted==0) {
			displayMenu();
		}
		
	

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

	public static int getChoice(String player_name){
		
		boolean validAnswer=true;
		Scanner input=new Scanner(System.in);
		int choice=0;
		
		do {
			try {
				
				if(validAnswer==false) {
					System.out.printf("%s,Enter the valid location number (1-9):",player_name);
					
				}else {
					System.out.printf("%s,Enter the location you want to mark (1-9):",player_name);
				}
			
				choice= Integer.parseInt(input.nextLine());
				
				if(!(1<=choice && choice<=9)) {
					validAnswer=false;
					
				}else {
					validAnswer=true;
				}
				
				
			}catch(NumberFormatException e) {
				System.out.println(e);
				validAnswer=false;
				
			}
			
			
			
		}while(!validAnswer);
		
		
		

		return choice;

	}

	public static int moveValidation(char[][] board,int choice){
		int validateMove;
			switch(choice){
				case 1:
					validateMove= board[0][0]=='1' ? 1 :0;
					break;
				case 2:
					validateMove= board[0][1]=='2' ? 1 :0;
					break;
				case 3:
					validateMove= board[0][2]=='3' ? 1 :0;
					break;

				case 4:
					validateMove= board[1][0]=='4' ? 1 :0;
					break;

				case 5:
					validateMove= board[1][1]=='5' ? 1 :0;
					break;

				case 6:
					validateMove= board[1][2]=='6' ? 1 :0;
					break;

				case 7:
					validateMove= board[2][0]=='7' ? 1 :0;
					break;

				case 8:
					validateMove= board[2][1]=='8' ? 1 :0;
					break;

				case 9:
					validateMove= board[2][2]=='9' ? 1 :0;
					break;

				default:
					validateMove=0;

			}

		return validateMove;

	}
	
	public static int changePlayer(int current_player) {
		int currentPlayer;
		
		currentPlayer= current_player==1 ? 2 :1;		
		
		return currentPlayer;
		
	}
	
	public static boolean gameWinCheck(char [][] board, char currentSymbol){

		
		//Horizontal Win Check
		for(int i=0;i<3;i++) {
			if(board[i][0]==currentSymbol && board[i][1]==currentSymbol && board[i][2]==currentSymbol){
				
				return true;
				
			}
		}
		//Vertical Win Check
		for(int i=0;i<3;i++) {
			if(board[0][i]==currentSymbol && board[1][i]==currentSymbol && board[2][i]==currentSymbol){
				
				return true;
				
			}
		}
		
		//Cross Win
		if(board[0][0]==currentSymbol && board[1][1]==currentSymbol && board[2][2]==currentSymbol || board[0][2]==currentSymbol && board[1][1]==currentSymbol && board[2][0]==currentSymbol ) {
			return true;
			
		}
		
		return false;
		
		
	}	
	
	
	public static char getSymbol(int current_player) {
		char currentSymbol;
		
		currentSymbol= current_player==1 ? 'X' : 'O';
		
		return currentSymbol;
		
	
	}
	

	public static void playGame(char board[][], int choice, char symbol){
		
		switch(choice){
		case 1:
			board[0][0]= symbol;
			break;
		case 2:
			 board[0][1]= symbol;
			break;
		case 3:
			 board[0][2]= symbol;
			break;

		case 4:
			 board[1][0]= symbol;
			break;

		case 5:
			 board[1][1]= symbol;
			break;

		case 6:
			 board[1][2]= symbol;
			break;

		case 7:
			 board[2][0]= symbol;
			break;

		case 8:
			 board[2][1]= symbol;
			break;

		case 9:
			 board[2][2]= symbol;
			break;

	}
		
		
	}
	
	
	public static void displayLeader(String[] playerNames,int currentPlayer, int turns) {
		
		System.out.printf("Congratulations! You won %s%n",playerNames[currentPlayer-1]);
		System.out.printf("Total number of turns: %d%n",turns);
	
	}
	
	
	public static void displayDrawMessage(int turns) {
			
			System.out.printf("Draw!\n");
			System.out.printf("Total number of turns: %d%n",turns);
		
	}
	
	
	
	public static int replayGame() {
		String restartGame;
		boolean isValidAnswer=true;
		Scanner input= new Scanner(System.in);
		do {
			
			if(isValidAnswer==false) {
				System.out.println("Please enter the valid character. Do you want to restart the game? (Y/N):");
	
			}else {
				System.out.println("Do you want to restart the game? (Y/N):");
			}
			
			restartGame= input.nextLine();
			if(restartGame.equals("Y")) {
				return 1;
			}
			else if(restartGame.equals("N")) {
				return 0;
			}
			else {
				isValidAnswer=false;
			}
		
			
		}while(!isValidAnswer);
		
		return 0;
	}
	

	
	
	
	
	
	public static void optionE() {}

	
	


}
