
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
	
<<<<<<< HEAD
	public static int maximum(int x,int y) {
		int maximumValue=x;
		if(y>x) {
			maximumValue=y;
			
		}
		
		return maximumValue;
		
	}
=======
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
		
>>>>>>> 89b6d828b045f40d9a0c370532d4ffd15d94e706

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
		if((board[0][0]==currentSymbol && board[1][1]==currentSymbol && board[2][2]==currentSymbol) || (board[0][2]==currentSymbol && board[1][1]==currentSymbol && board[2][0]==currentSymbol)) {
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

	
<<<<<<< HEAD




=======
>>>>>>> 89b6d828b045f40d9a0c370532d4ffd15d94e706




    
}
