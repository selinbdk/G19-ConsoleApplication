
import java.util.Scanner;



public class ConsoleApplication {
    public static void main(String[] args) {
		
        displayIntro();
		displayMenu();
		

    }

    public static void displayIntro() {
		
		String[] teamMembers= {
				
		"********************",
		"*     GROUP19      *",
		"*   SELIN BUDAK    *",
		"* TUGBA CAGLAGONUL *",
		"* EKMEL BEYZA AKIN *",
		"* BERKAY KARATAS   *",
		"* FURKAN KAPUSUZ   *",
		"********************"
				
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
				//System.out.print("\033c"); 
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
	
	

	public static void optionA() {
		
		Scanner scanner = new Scanner(System.in);
		String answer="";
        int size=0;
        boolean isAnswerValid=true;
        
        //Getting the array size
        do {
        	try {
            System.out.print("Enter the size of the array (positive integer): ");
            answer= scanner.nextLine();
       	 	size= Integer.parseInt(answer);
       	 	isAnswerValid=true;
       	 	
            if (size <= 0) {
                System.out.println("Size must be a positive integer.");
                isAnswerValid=false;
               
            }
        	}catch(NumberFormatException e) {
        		System.out.println(e);
        		isAnswerValid=false;
        		
        	}
            
        } while (!isAnswerValid);
        
        double[] array = new double[size]; // creating an array
        
        
        
        //Filling the array
        for (int i = 0; i < size; i++) {
        	
        	do {
            	try {
            	 if (isAnswerValid==false) { 
                	 System.out.println("Invalid input. Please enter a double number:");
                    
                 }else {
                	 System.out.print("Enter element: ");
                 }
                 answer=scanner.nextLine();
                 array[i] = Double.parseDouble(answer);
            	 isAnswerValid=true;
            	
            	 }catch(NumberFormatException e) {
            		 System.out.println(e);
            		 isAnswerValid=false;
            	 }
          
              } while (!isAnswerValid); 
        	
        }
        
        //Doing calculations (calling methods)
        double median = findMedian(array);
        double arithmetic = arithmeticMean(array);
        double geometric = geometricMean(array);
        double harmonic = harmonicMean(array, size, 0, 0);
        //Showing the results
        System.out.println("--------------------");
        System.out.println("\n The Calculations: \n");
        System.out.println("Median: " + median);
        System.out.println("Arithmetic Mean: " + arithmetic);
    
        if (geometric != -1) {
            System.out.println("Geometric Mean: " + geometric);
        } else {
            System.out.println("Geometric mean can only be calculated for positive numbers or zero.");
        }
    
        if (harmonic != -1) {
            System.out.println("Harmonic Mean: " + harmonic);
        } else {
            System.out.println("Harmonic mean can only be calculated for positive numbers.");
        }
        System.out.println("--------------------");
        
        

	       int isReturned= returnPreviousMenu();
	       
			if(isReturned==1) {
				displayMenu();
				
			}
			else{
				optionA();
			}
        
        
        
        scanner.close();
    
		
	}
	
	
	 //Method to sort an array
    public static void SortArray(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    
                    double temp = array[j]; //swapping
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    
    // Method to find the MEDIAN
    public static double findMedian(double[] array) {
        SortArray(array); // Sort the array
        
        int size = array.length;
        if (size % 2 == 1) { // Odd size
            return array[size / 2];
        } else { // Even size
            return (array[(size / 2) - 1] + array[size / 2]) / 2;
        }
    }
    
    
 // Method to calculate the ARITHMETIC MEAN
    public static double arithmeticMean(double[] array) {
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    
    
 // Method to calculate the GEOMETRIC MEAN  
    public static double geometricMean(double[] array) {
    double product = 1.0;
    for (double num : array) {
        if (num < 0) {
            return -1; // If any negative value, return -1
        }
        product *= num;
    }
    // calculating the nth root
    int size = array.length;
    double geometricMean = Math.pow(product, 1.0 / size);
    return geometricMean;
}
    
    
    
 // Method to calculate the HARMONIC MEAN
    public static double harmonicMean(double[] array, int size, int index, double sum) {
        
        // checking if all elements are positive
        for (double num : array) {
            if (num <= 0) {
                return -1; //if negative number or zero as input
            }
        }
        if (index == size) { // base case for recursion
            return size / sum;
        }
        
        return harmonicMean(array, size, index + 1, sum + 1 / array[index]); // recursive call
    }
	
	
	
	
	

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
				matrixMultiplication();
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
		
		System.out.println("\n[a] Transpose");

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
        
        
        int isReturned= returnPreviousMenu();
	       
			if(isReturned==1) {
				subMenu();
				
			}
			else{
				transpose();
			}

		

    }


	public static void inverse() {

        //
	}

	public static void matrixMultiplication() {
		
		System.out.println("\n[c] Matrix Multiplication\n");
	      
	        Scanner input5 = new Scanner(System.in);
	        int m1=0;
	        int m2=0;
	        int n1=0;
	        int n2=0;

	        boolean isAnswerValid=true;
	        String answer="";
	        
	        
	        do {
	            try {
	            	
		        	if(isAnswerValid==false) {
		        		System.out.println("Please enter a valid row number for first matrix:");
		        		
		        	}
		        	else {
		        		 System.out.print("Please enter a first matrix row:");
			        	
		        	}
		        	
		        	answer=input5.nextLine();
		        	m1= Integer.parseInt(answer);
		        	if(m1<=0) {
		        		isAnswerValid=false;
		        	}
		        	else {
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
		        		System.out.println("Please enter a valid column number for first matrix:");
		        		
		        	}
		        	else {
		        		 System.out.print("Please enter a first matrix column:");
			        	
		        	}
		        	
		        	answer=input5.nextLine();
		        	n1= Integer.parseInt(answer);
		        	if(n1<=0) {
		        		isAnswerValid=false;
		        	}
		        	else {
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
		        		System.out.println("Please enter a valid row number for second matrix:");
		        		
		        	}
		        	else {
		        		 System.out.print("Please enter a second matrix row:");
			        	
		        	}
		        	
		        	answer=input5.nextLine();
		        	m2= Integer.parseInt(answer);
		        	if(m2<=0) {
		        		isAnswerValid=false;
		        	}
		        	else {
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
		        		System.out.println("Please enter a valid column number for second matrix:");
		        		
		        	}
		        	else {
		        		 System.out.print("Please enter a second matrix column:");
			        	
		        	}
		        	
		        	answer=input5.nextLine();
		        	n2= Integer.parseInt(answer);
		        	if(n2<=0) {
		        		isAnswerValid=false;
		        	}
		        	else {
		        		isAnswerValid=true;
		        	}
		        	
		        
	            }catch(NumberFormatException e) {
	            	System.out.println(e);
	            	isAnswerValid=false;
	            	
	            	}
	            
	        } while (!isAnswerValid);
        
       
    	 if(n1!=m2) {
    		 System.out.println("Please valid input.First matrix columns must equal second matrix rows input.");
    		 matrixMultiplication();
    		 
    	 }else {

    		 
 	        double[][] matrix1 = new double[m1][n1];
 	        double[][] matrix2 = new double[m2][n2];

 	        
 	        boolean validInput=true;
 	        
 	        // get first matrix's value
 	        System.out.println("Please enter first matrix values:");
 	        for (int i = 0; i < m1; i++) {
 	            for (int j = 0; j < n1; j++) {
 	            	
 	            	 do {
 	                   	try {
 	                   	 if (validInput==false) { 
 	                       	 System.out.println("Invalid input. Please enter a double number:");
 	                           
 	                        }else {
 	                       	 System.out.printf("Enter matrix1[%d][%d] values: ", i,j);
 	                        }
 	              
 	                     answer=input5.nextLine();
 	                   	 matrix1[i][j] = Double.parseDouble(answer);
 	                   	 validInput=true;
 	                   	
 	                   	 }catch(NumberFormatException e) {
 	                   		 System.out.println(e);
 	                   		 validInput=false;
 	                   	 }
 	                 
 	                     } while (!validInput); 
 	               
 	            	
 	            }
 	        }

 	        // get second matrix value.
 	        System.out.println("Please enter second matrix values:");
 	        for (int i = 0; i < m2; i++) {
 	            for (int j = 0; j < n2; j++) {
 	            	
 	            	 do {
  	                   	try {
  	                   	 if (validInput==false) { 
  	                       	 System.out.println("Invalid input. Please enter a double number:");
  	                           
  	                        }else {
  	                       	 System.out.printf("Enter matrix2[%d][%d] values: ", i,j);
  	                        }
  	              
  	                     answer=input5.nextLine();
  	                   	 matrix2[i][j] = Double.parseDouble(answer);
  	                   	 validInput=true;
  	                   	
  	                   	 }catch(NumberFormatException e) {
  	                   		 System.out.println(e);
  	                   		 validInput=false;
  	                   	 }
  	                 
  	                     } while (!validInput); 
  	               
 	       
 	            }
 	        }


 	        // calculation multiply
 	        double[][] result = multiplyMatrices(matrix1, matrix2);

 	       System.out.println("Your first matrix:");
 	       
 	       for(double[] row : matrix1 ) {
 	    	   for(double val : row) {
 	    		   
 	    		  System.out.printf("%10.2f\t",val);
 	    		   
 	    	   }
 	    	   System.out.println();
 	    	   
 	       }
 	      
 	      System.out.println("Your second matrix:");
 	      for(double[] row : matrix2 ) {
	    	   for(double val : row) {
	    		   
	    		  System.out.printf("%10.2f\t",val);
	    		   
	    	   }
	    	   
	    	   System.out.println();
	       }
 	        

 	        // print result on the screen 
 	        System.out.println("Calculated matrix result:");
 	        
 	       for (int i = 0; i < result.length; i++) {
 	            for (int j = 0; j < result[i].length; j++) {
 	            	System.out.printf("%10.2f\t",result[i][j]);
 	            }
 	            System.out.println();
 	        }
 	        

 	       
 	       int isReturned= returnPreviousMenu();
 	       
 			if(isReturned==1) {
 				subMenu();
 				
 			}
 			else{
 				matrixMultiplication();
 			}
 	
 	       
 		}

    	 }
	        

	    public static double[][] multiplyMatrices(double[][] mat1, double[][] mat2) {
	        int m = mat1.length;          // first matrix's rows value
	        int n = mat1[0].length;       // first matrix's columns value
	        int p = mat2[0].length;       // second matrix's columns value

	        double[][] result = new double[m][p];

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

	

	    
	public static void element_wiseMultiplication() {
		
		System.out.println("\n[d] Element-wise Multiplication\n");
		Scanner input6 = new Scanner(System.in);
        int r=0;
        int c=0;

        
        boolean isAnswerValid=true;
        String answer="";
        
        
        do {
            try {
            	
	        	if(isAnswerValid==false) {
	        		System.out.println("Please enter a valid row number for matrices:");
	        		
	        	}
	        	else {
	        		 System.out.print("Please enter a row number for matrices:");
		        	
	        	}
	        	
	        	answer=input6.nextLine();
	        	r= Integer.parseInt(answer);
	        	if(r<=0) {
	        		isAnswerValid=false;
	        	}
	        	else {
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
	        		System.out.println("Please enter a valid column number for matrices:");
	        		
	        	}
	        	else {
	        		 System.out.print("Please enter a column number for matrices:");
		        	
	        	}
	        	
	        	answer=input6.nextLine();
	        	c= Integer.parseInt(answer);
	        	if(c<=0) {
	        		isAnswerValid=false;
	        	}
	        	else {
	        		isAnswerValid=true;
	        	}
	        
            }catch(NumberFormatException e) {
            	System.out.println(e);
            	isAnswerValid=false;
            	
            	}
            
        } while (!isAnswerValid);
        
        double[][] matrix1 = new double[r][c];
		double[][] matrix2 = new double[r][c];
		double[][] matrixR = new double[r][c];
        
        

	        
	        // get first matrix's value
	        System.out.println("Please enter first matrix values:");
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	            	
	            	 do {
	                   	try {
	                   	 if (isAnswerValid==false) { 
	                       	 System.out.println("Invalid input. Please enter a double number:");
	                           
	                        }else {
	                       	 System.out.printf("Enter matrix1[%d][%d] values: ", i,j);
	                        }
	              
	                     answer=input6.nextLine();
	                   	 matrix1[i][j] = Double.parseDouble(answer);
	                   	isAnswerValid=true;
	                   	
	                   	 }catch(NumberFormatException e) {
	                   		 System.out.println(e);
	                   		isAnswerValid=false;
	                   	 }
	                 
	                     } while (!isAnswerValid); 
	               
	            	
	            }
	        }
	        
	        
	        System.out.println("Please enter second matrix values:");
 	        for (int i = 0; i < r; i++) {
 	            for (int j = 0; j < c; j++) {
 	            	
 	            	 do {
  	                   	try {
  	                   	 if (isAnswerValid==false) { 
  	                       	 System.out.println("Invalid input. Please enter a double number:");
  	                           
  	                        }else {
  	                       	 System.out.printf("Enter matrix2[%d][%d] values: ", i,j);
  	                        }
  	              
  	                     answer=input6.nextLine();
  	                   	 matrix2[i][j] = Double.parseDouble(answer);
  	                   isAnswerValid=true;
  	                   	
  	                   	 }catch(NumberFormatException e) {
  	                   		 System.out.println(e);
  	                   	isAnswerValid=false;
  	                   	 }
  	                 
  	                     } while (!isAnswerValid); 
  	               
 	            }
 	        }
		
 	       for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					matrixR[i][j] = matrix1[i][j]*matrix2[i][j];
				}
			}
 	       
 	       
 	      System.out.println("Your first matrix:");
	       
	       for(double[] row : matrix1 ) {
	    	   for(double val : row) {
	    		   
	    		  System.out.printf("%10.2f\t",val);
	    		   
	    	   }
	    	   System.out.println();
	    	   
	       }
	      
	      System.out.println("Your second matrix:");
	      for(double[] row : matrix2 ) {
	    	   for(double val : row) {
	    		   
	    		  System.out.printf("%10.2f\t",val);
	    		   
	    	   }
	    	   
	    	   System.out.println();
	       }
 	       
 	      
 	
			System.out.println("Element-wise multiplication:");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.printf("%10.2f\t",matrixR[i][j]);
           
				}
				System.out.print("\n");
			}
		
			 
	 	       int isReturned= returnPreviousMenu();
	 	       
	 			if(isReturned==1) {
	 				subMenu();
	 				
	 			}
	 			else{
	 				element_wiseMultiplication();
	 			}
	 			
	 		
	 			
	}
		
		
		

	public static void returnMenu(){
		
		displayMenu();
        
	}



	public static int returnPreviousMenu() {
		String restartOperation;
		boolean isValidAnswer=true;
		Scanner input= new Scanner(System.in);
		do {
			
			if(isValidAnswer==false) {
				System.out.println("Please enter the valid character. Do you want to return to the previous menu? (Y/N):");
	
			}else {
				System.out.println("Do you want to return to the previous menu? (Y/N):");
			}
			
			restartOperation= input.nextLine();
			if(restartOperation.equals("Y")) {
				return 1;
			}
			else if(restartOperation.equals("N")) {
				return 0;
			}
			else {
				isValidAnswer=false;
			}
		
			
		}while(!isValidAnswer);
		
		return 0;
	}
	



	public static void optionC() {}

	
	
	/**
	 * This function allows us to play the tic-tac-toe game. Other methods related to the operation of this game are followed in this function.
	 */
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

	
	/**This method prints the game board.
	 * 
	 * @param board the board of tic-tac-toe game.
	 */
	
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

	/**
	 * This method asks the player to choose a number between 1 and 9 for the placement of their symbol.
	 * @param player_name name entered by player
	 * @return choice of the player
	 */
	
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

	/**
	 * This method checks whether the player's choice is valid. 
	 * @param board the board of tic-tac-toe game.
	 * @param choice choice of the player for the placement of their symbol.
	 * @return The status of whether the player's choice is valid or not
	 */
	
	
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
	
	/**
	 * This method allows to keep track of the order of the players to play the game.
	 * @param current_player the current player's number. These numbers are 1 for Player1 (X), 2 for PLayer2 (O).
	 * @return the player's number whose turn it is to play.
	 */
	
	public static int changePlayer(int current_player) {
		int currentPlayer;
		
		currentPlayer= current_player==1 ? 2 :1;		
		
		return currentPlayer;
		
	}
	
	
	
	/**
	 * This method provides information whether there is a winning player in the game.
	 * @param board the board of tic-tac-toe game.
	 * @param currentSymbol symbol of the current player (X or O).
	 * @return true if there is a winning player in the game, false otherwise.
	 */
	
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
	
	
	
	/**
	 * This method allows us to obtain the symbols of the players.
	 * @param current_player the current player's number. These numbers are 1 for Player1 (X), 2 for PLayer2 (O).
	 * @return the current player's symbol.
	 */
	
	public static char getSymbol(int current_player) {
		char currentSymbol;
		
		currentSymbol= current_player==1 ? 'X' : 'O';
		
		return currentSymbol;
		
	
	}
	

	
	/**
	 * This method allows the player's symbol to be placed at the desired location.
	 * @param board the board of tic-tac-toe game.
	 * @param choice choice of the player for the placement of their symbol.
	 * @param symbol the current player's symbol.
	 */
	
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
	
	
	
	/**
	 * This method prints the name of the winning player and the total number of turns.
	 * @param playerNames array that collects the names entered by the player.
	 * @param currentPlayer the current player's number. These numbers are 1 for Player1 (X), 2 for PLayer2 (O).
	 * @param turns total number of turns in the game.
	 */
	
	public static void displayLeader(String[] playerNames,int currentPlayer, int turns) {
		
		System.out.printf("Congratulations! You won %s%n",playerNames[currentPlayer-1]);
		System.out.printf("Total number of turns: %d%n",turns);
	
	}
	
	
	
	/**
	 * This method prints a message informing you that the game ended in a draw and the total number of turns.
	 * @param turns total number of turns in the game.
	 */
	public static void displayDrawMessage(int turns) {
			
			System.out.printf("Draw!\n");
			System.out.printf("Total number of turns: %d%n",turns);
		
	}
	
	
	
	/**
	 * This method asks players if they want to play the game again.
	 * @return if they want to play again, 1 is returned. If they don't want to play again, 0 is returned.
	 */
	
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
