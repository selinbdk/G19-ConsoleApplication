
import java.util.Scanner;



/**
 * This class implements a console application. At first, a welcome message appears with an ascii art and the menu appears. Thus the application starts. Various operations such as statistical Information about an array, 
 * Matrix Operations, Text Encryption/Decryption, and Tic-tac-toe HotSeat are performed in this console application.
 * 
 * @author SELIN BUDAK, TUGBA CAGLAGONUL, EKMEL BEYZA AKIN, BERKAY KARATAS, FURKAN KAPUSUZ
 * 
 */

public class Group19 {
	
    public static void main(String[] args) {
		
        displayIntro();
		displayMenu();
		
    }

    
    /**
     * This method allows the introduction part of the application to be displayed.
     * With this function, the names of the group members, a smiley face made with ascii art and a welcome message are printed.
     * Proper printing of these patterns has been achieved with some methods and loops.
     */
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
	
    
    
    /**
     * With this method, first the operations in the Console Application program are displayed. The user is then asked to make a selection.
     * The user is routed according to the selected operation.
     */
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

		}
		
	}
	
	
	
	/**
	 * This method finds the maximum among the two integer numbers given as parameters.
	 * @param x parameter whose size is to be compared
	 * @param y parameter whose size is to be compared
	 * @return The maximum of the two parameters is returned.
	 */
	public static int maximum(int x,int y) {
		int maximumValue=x;
		if(y>x) {
			maximumValue=y;
			
		}
		
		return maximumValue;
		
	}
	
	
	
	
	/**
	 * With this method, statistical information about the array entered by the user is given to the user. 
	 * Operations such as median, arithmetic mean,geometric mean and harmonic mean are calculated and displayed to the user.
	 * 
	 */
	public static void optionA() {
		
		System.out.println("\n[A] Statistical Information about an array");
		Scanner scanner = new Scanner(System.in);
		String answer="";
        int size=0;
        boolean isAnswerValid=true;
        
        //Getting the array size
        do {
        	try {
            System.out.print("\nEnter the size of the array (positive integer): ");
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
        double median = median(array);
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
	
	/**
     * "sortArray" method sorts the element of our array in an ascending order. This will be requried for finding the median later.
     * It's parameter is "double[] array". Because it will be called with an array that contains "double" type elements (that user chose).
     * It doesnt't have a return because all arrays are automatically called by reference. So it's type is "void".
     
     * @param array an array entered by user.
     */

     //Method to sort an array
     public static void sortArray(double[] array) {
         int n = array.length;
         for (int i = 0; i < n - 1; i++) {
             for (int j = i+1; j < n; j++) {
                 if (array[i] > array[j]) {
                     
                     double temp = array[j]; //swapping
                     array[j] = array[i];
                     array[i] = temp;
                 }
             }
         }
     }
     
     
     
     /**
      * Median finds the median,
      * It's parameter is "double[] array" because it will take the array that contains double-typed values.
      * Its return type is double since it will return the found element (that was double-typed).
      * The method will first call the "SortArray" method so that the elements will be in ascending order.
      * Then we will see if the array is odd sized, if so, the element in the middle index will be the median.
      *"size / 2" will give us the index of the median. if there are 3 elements, the (0-1-2) index 1's element will be the median. 
      *3/2=1.5 but since it is an index, computer will take it as "1" since index should be an intager.
      *If the array is even-sized, then we will take the 2 elements in the middle, then calculate the mean of them.
      *"(size / 2) - 1" th index and "size / 2" th index.
      * @param arr an array entered by user.
      * @return median is returned
      */
     // Method to find the MEDIAN
     public static double median(double[] arr) {
         sortArray(arr); // Sort the array
         
         int size = arr.length;
         if (size % 2 == 1) { // odd sized array
             return arr[size / 2]; //since integers, it will take "1,5" as "1" for example.
         } else { // even sized array
             return (arr[(size / 2) - 1] + arr[size / 2]) / 2; //since index numbers starts from 0
         }
     }
 
     /**
      * arithmeticMean calculates the arithmetic mean of the array's all elements.
      * it's parameter is "double[] array" since it takes an array that contains double-typed elements.
      *it iterates over all of the elements of the array and sums all of the elements.
      *then it will divide this sum with the total number of elements (the length of the array) and return this value. 
      * @param array an array entered by the user
      * @return arithmetic mean is returned.
      */

     // Method to calculate the ARITHMETIC MEAN
     public static double arithmeticMean(double[] array) {
         double sum = 0;
         for (double num : array) { //going through every element in the array
             sum += num;
         }
         return sum / array.length;
     }
     
     /**
      * the method "geometricMean" calculates and returns the geometric mean of all the elements in the passed array.
      * it's parameter is "double[] arr" since it will be called by the array which contains double-typed elements.
      * geometric mean is calculated by multiplying all the elements together, then taking the n-th root of this product. (n is the total number of elements in the array)
      * in order to do the multiplication, we need a varible p for, and go through every element in the array and multiplying it with the previous product. the first product is initialized as 1.0
      * we will call the "Math.pow" a java method to calculate the n-th root of our product.
      * Also for geometric mean we can only use 0 and positive numbers. so if there are any negative elements, the "geometricMean" method will return -1 without doing any calculations.
      * 
      * @param arr an array entered by user.
      * @return geometric mean is returned.
      */
    // Method to calculate the GEOMETRIC MEAN  

     public static double geometricMean(double[] arr) {
     double p = 1.0;

     for (double element : arr) {
         if (element < 0) {
             return -1; // If any negative value, return -1
         }
         p*= element; //producting (çarpmak) every element in the array
     }
 
     // calculating the n-th root //n is the size of the array
     int n = arr.length;
     double geometricMean = Math.pow(p, 1.0 / n); //this will calculate the n-th degree root of the product (çarpım) of all elements
 
     return geometricMean;
 }
 
 /**
  * "harmonicMean" calculates the harmonic mean of all of the elements in the array.
  * It's parameters are "double[] arr, int n, int i, double sum" and we will call this method by "array, n, 0, 0" as arguments later in the code. (n = our array's size)
  * for harmonic mean, we should only use numbers that are bigger than zero. so if there is any negative values or 0, the method will return -1 without doing any calculations.
  * for harmonic mean calculation we will sum every element's "1/element" version (1 / arr[i]). then we will divide the total number of elements (n) to this summation. (n/sum)
  * if all the elements are covered (i == n), then we will return this n/sum value as the answer.
  * if we didn't reach this final condition, then we will call the "harmonicMean" method over and over again with the previous values. (recursive call).
  *we do this recursive call in order to make the summation. we do "i+1" to pass to the next element of the array.
  * @param arr an array entered by user.
  * @param n size of the array
  * @param i index
  * @param sum sum of all the elements of the array
  * @return harmonic mean is returned
  */
 // Method to calculate the HARMONIC MEAN
 public static double harmonicMean(double[] arr, int n, int i, double sum) {
     
     // checking if all elements are positive
     for (double element : arr) {
         if (element <= 0) {
             return -1; //if negative number or zero as input
         }
     }
 
     if (i == n) { // base case for recursion
         return n / sum;
     }
     
     return harmonicMean(arr, n, i + 1, sum + 1 / arr[i]); // recursive call
 }
    
    
    
    
	
	
	/**
	 * This method allows user to route when the user wants to do some matrix operations.
	 *  When this function is called, a submenu containing matrix operations opens.
	 */
	public static void optionB() {
		matrixSubMenu();
	}

	
	
	/**
	 * This function provides the user with a submenu containing various matrix operations.
	 */
	public static void matrixSubMenu() {
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
				System.out.print("Please enter a valid operation character:");

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


		
		}

	}	


	
	/**
	 * This method is used to find the matrix entered by the user, the transpose matrix.
	 */
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
				matrixSubMenu();
				
			}
			else{
				transpose();
			}

    }

	/**
	 * This method is used to find the inverse of the entered matrix. In order to find the inverse of a matrix, 
	 * the number of rows and columns must be equal, that is, it must be (nxn) in size. Also, a matrix whose determinant is zero has no inverse.
	 */
	
	public static void inverse() {
		
		System.out.println("\n[b] Inverse");
		Scanner input4 = new Scanner(System.in);
        boolean isAnswerValid=true;
        String answer="";
        int rows=0;
        int columns=0;
        do {
            try {
            	
	        	if(isAnswerValid==false) {
	        		System.out.println("\nPlease enter a valid row number:");
	        		
	        	}
	        	else {
	        		System.out.println("Please enter the total number of rows as a positive integer:");
	        	}
	        	
	        	 answer=input4.nextLine();
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
	        	
	        	 answer=input4.nextLine();
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
        
        if(rows!=columns) {
        	System.out.println("The number of rows and columns must be equal. Try again.");
        	inverse();
        	}
        else {
        	int size=rows;
            boolean validInput = true;
            double[][] matrix = new double[size][size];
            double[][] inverseMatrix = new double[size][size];
           
       
            
            for (int i = 0; i < size; i++) { 
                for (int j = 0; j < size; j++) { 
                   
                   do {
                    	try {
                    	 if (validInput==false) { 
                        	 System.out.println("Invalid input. Please enter a double number:");
                            
                         }else {
                        	 System.out.printf("Enter [%d][%d] values: ", i,j);
                         }
               
                         answer=input4.nextLine();
                    	 matrix[i][j] = Double.parseDouble(answer);
                    	 validInput=true;
                    	
                    	 }catch(NumberFormatException e) {
                    		 System.out.println(e);
                    		 validInput=false;
                    	 }
                  
                      } while (!validInput); 
                 }
            }
            
            double determinantSum=determinantCalculation(matrix,size);
            if(determinantSum==0) {
            System.out.println("The determinant of the entered matrix is ​​Zero. This matrix has no inverse.");
            
            int isReturned= returnPreviousMenu();
  	       
				if(isReturned==1) {
					matrixSubMenu();
					
				}
				else{
					inverse();
				}
	            
            
           
            }else {
            	calculateInverseOfMatrix(matrix,inverseMatrix,size,determinantSum);
            	
            	

            	System.out.println("\nYour matrix:");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                    	System.out.printf("%10.2f\t",matrix[i][j]);
                    }
                    System.out.println();
                }
            	
            	
     
            	
            	System.out.println("\nInverse of your matrix:");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                    	System.out.printf("%10.2f\t",inverseMatrix[i][j]);
                    }
                    System.out.println();
                }
                
                int isReturned= returnPreviousMenu();
     	       
    			if(isReturned==1) {
    				matrixSubMenu();
    				
    			}
    			else{
    				inverse();
    			}
                
                
                
            }
           
        }
       
	}
	
	
	/**
	 * This function allows us to access the minor matrix. Minor matrix values ​​are necessary to invert the matrix.
	 * @param matrix matrix entered by the user.
	 * @param result array in which the answer will be temporarily kept.
	 * @param rowIndex the row number ignored to find the minor matrix.
	 * @param columnIndex the column number ignored to find the minor matrix.
	 * @param size size of the matrix.
	 */
	public static void getMinorMatrix(double [][] matrix, double [][] result, int rowIndex, int columnIndex, int size) {
		
		int i=0;
		int j=0;
		
		for(int rowNumber=0; rowNumber<size;rowNumber++) {
			for(int columnNumber=0; columnNumber<size ;columnNumber++) {
				if(rowNumber!= rowIndex && columnNumber != columnIndex) {
					result[i][j]=matrix[rowNumber][columnNumber];
					j++;
					if(j==size-1) {
						j=0;
						i++;
					}
					
				}
				
				
			}
			
		}
	}
	
	/**
	 * With this method, the determinant of the entered matrix is ​​calculated. Calculating the determinant is necessary to invert a matrix. 
	 * Matrices with zero determinants cannot be inverted. It is important to control this situation.
	 * @param matrix matrix entered by the user.
	 * @param size size of the entered matrix
	 * @return determinant of the entered matrix
	 */
	
	public static double determinantCalculation(double [][] matrix,int size) {
		
		double determinantSum=0;
		int multiplier=1;
		double[][] result = new double[size][size];
		
		if(size==1) {
			return matrix[0][0];
			
		}
		
		for(int i=0;i<size;i++) {
			
			getMinorMatrix(matrix,result,0,i,size);
			determinantSum+=multiplier*matrix[0][i]*determinantCalculation(result,size-1);
			multiplier*=-1;
		}
		
		return determinantSum;
		
		
	}
	
	
	/**
	 * This function calculates the inverse of the entered matrix.
	 * @param matrix matrix entered by the user.
	 * @param inverseMatrix the inverse of the entered matrix is ​​kept in this matrix.
	 * @param size size of the entered matrix.
	 * @param determinantSum determinant of the entered matrix.
	 */
	public static void calculateInverseOfMatrix(double[][] matrix, double[][] inverseMatrix, int size, double determinantSum) {
		
		double[][] minorMatrix= new double[size][size];
		int multiplier=1;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if((i+j)%2==0) {
					multiplier=1;
				}
				else {
					multiplier=-1;
				}
				getMinorMatrix(matrix,minorMatrix,i,j,size);
				
				double valueOfCofactor= determinantCalculation(minorMatrix,size-1)* multiplier;
				
				inverseMatrix[j][i]= valueOfCofactor/determinantSum;
				
			}
		}
		
	}

	
	/**	
	 * This method is used to find the matrix multiplication of entered matrices.
	 */
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

 	       System.out.println("\nYour first matrix:");
 	       
 	       for(double[] row : matrix1 ) {
 	    	   for(double val : row) {
 	    		   
 	    		  System.out.printf("%10.2f\t",val);
 	    		   
 	    	   }
 	    	   System.out.println();
 	    	   
 	       }
 	      
 	      System.out.println("\nYour second matrix:");
 	      for(double[] row : matrix2 ) {
	    	   for(double val : row) {
	    		   
	    		  System.out.printf("%10.2f\t",val);
	    		   
	    	   }
	    	   
	    	   System.out.println();
	       }
 	        

 	        // print result on the screen 
 	        System.out.println("\nCalculated matrix result:");
 	        
 	       for (int i = 0; i < result.length; i++) {
 	            for (int j = 0; j < result[i].length; j++) {
 	            	System.out.printf("%10.2f\t",result[i][j]);
 	            }
 	            System.out.println();
 	        }
 	        

 	       
 	       int isReturned= returnPreviousMenu();
 	       
 			if(isReturned==1) {
 				matrixSubMenu();
 				
 			}
 			else{
 				matrixMultiplication();
 			}
 	
 	       
 		}

    	 }
	        
	
	/**
	 * this function gets two parameter and multiply it.
	 * @param mat1 this is first entered matrix
	 * @param mat2 this is second entered matrix
	 * @return this return result(matrix multiplication result)
	 */
	
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
	    

   /**
	* This method used to find element wise multiplication with entered matrix
    */
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
	 				matrixSubMenu();
	 				
	 			}
	 			else{
	 				element_wiseMultiplication();
	 			}
	 			
	 		
	 			
	}
		
		
	/**
	 * This method allows the user to return to the main menu.
	 */

	public static void returnMenu(){
		
		displayMenu();
        
	}

	
	/**
	 * This method provides routing in the program. After the desired operation is completed, the user can return to the previous menu.
	 * @return If the user wants to return to the menu, 1 is returned. Otherwise 0 is returned.
	 */
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
	

	/**
     * This encryption method offers some options for encryption and decryption, takes user input,
     * and presents the selected operation (encryption or decryption) as output to the user.
     * It also provides an option for the user to return to the main menu.
     */
	public static void optionC() {
		
	
		String operation="";
		
		System.out.println(
				  " [a] Encryption,\n"
				+ " [b] Decryption,\n"
				+ " [c] Return to the Main Menu.\n");
		
		System.out.println("Caesar Cipher - Simple Version");
      
		Scanner scanner = new Scanner(System.in);
      
        boolean operationResult = true;
        boolean isAnswerValid=true;

        do {

			if(!operationResult){
				System.out.print("Please enter a valid operation character:");

			}else{
				System.out.print("Select the action you want to perform:");
			}
			operation =scanner.nextLine();
			operationResult= ((operation.equals("a")) || (operation.equals("b")) || (operation.equals("c")));
			
		} while (!operationResult);
       
        
        	if(operation.equals("c")){
        		displayMenu();
        	}
        
        
        
            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            
            int shift = 0;
            String answer = "";
            do {
                try {
                    if (!isAnswerValid) {
                        System.out.println("Please enter a valid integer for shift value:");
                    } else {
                        System.out.print("Enter the shift value: ");
                    }

                    answer = scanner.nextLine();
                    shift = Integer.parseInt(answer);  // we change shift to int//

                    // the shift must be between -26 and 26//
                    if (shift < -26 || shift > 26) {
                        isAnswerValid = false;
                        System.out.println("It is an error. You must change your shift. The shift must be between -26 and 26.");
                    } else {
                        isAnswerValid = true;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("It is invalid. Enter a valid shift.");
                    isAnswerValid = false;
                }
            } while (!isAnswerValid);

            if (operation.equals("a")) {
                System.out.println("Ciphertext: " + encrypt(text, shift));
            } else if (operation.equals("b")) {
                System.out.println("Deciphered text: " + decrypt(text, shift));
               
            } 
            else {
                System.out.println("Invalid selection.");
            }

            // we ask the menu//
            System.out.print("You will be directed to the main menu. If you want, you can return to the previous menu.\n");
            int subMenuChoice = returnPreviousMenu();
            if (subMenuChoice == 1) {
           
            	 optionC();
            } else {
              returnMenu();
               
            }
            scanner.close();
        }

      
	/**
     * The Caesar cipher method is used to encrypt a message.
     * 
     * @param message the message to be encrypted
     * @param shift Shows the number of positions each letter in the message has been shifted
     * @return displays the encrypted message as a string
     */
	 public static String encrypt(String message, int shift) {
	        String encrypted = ""; 
	        for (int i = 0; i < message.length(); i++) {
	            char c = message.charAt(i);

	            if (Character.isLetter(c)) {
	                char base = Character.isLowerCase(c) ? 'a' : 'A';
	                c = (char) ((c - base + shift + 26) % 26 + base);  
	            }
	            
	          
	            c = (char) (c % 128);
	            
	            encrypted += c;  
	        }
	        return encrypted;
	    }

	 
	 /**
	  * We use the Caesar cipher method and decrypt the encrypted message.
	  * 
	  * @param message the message to be decrypted
	  * @param shift Shows the number of positions each letter in the message was shifted during encryption
	  * @return serves to display the decrypted message as a string
	  */
	public static String decrypt(String message, int shift) {
	     return encrypt(message, -shift);  // It allows us to solve the password by doing reverse shift.//
	}
	    
	

	
	
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
	

	/**
	 * This function is called when the user wants to terminate the application. 
	 * Terminating the application is not provided in this function, it is provided in displayMenu() function.
	 */
	public static void optionE() {}

	
	


}
