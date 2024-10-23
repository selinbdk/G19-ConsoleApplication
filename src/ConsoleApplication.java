
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

	public static void optionB() {}

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

	








    
}
