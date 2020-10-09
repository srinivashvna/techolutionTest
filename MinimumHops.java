import java.util.*; 
import java.io.*; 

class MinimumHops { 
	 
	//code 
	public static void main(String args[]) 
	{ 
	
	  Scanner s = new Scanner(System.in);
	  
      System.out.println("Enter the number  of Compartments in the train:");
	  
      int length = s.nextInt();
	  
	  if (length != 0){
	  
	  int [] myArray = new int[length];
	  
      System.out.println("Enter the threshold values of Jetpack for each compartment:");

      for(int i=0; i<length; i++ ) {
	  
	  int threshold= s.nextInt();
	  
		 if (threshold!= 0){
		 	myArray[i] = threshold;
		 }
		 else{
		 	System.out.println("Jetpack Threshold cant be zero");
		 }
      }

      System.out.println(Arrays.toString(myArray));
	  
	  System.out.println("Enter the compartment number in which the theisis  is in:");
	  
	  int compartmentNum = s.nextInt();
	  
	  if (compartmentNum != 0){
	  
	  int n = myArray.length; 
	  
	  if(compartmentNum<=n){
	  
	  System.out.print("Minimum number of hops to reach compartment is "+ minHops(myArray, 0 , compartmentNum)); 
						}
						else{
							System.out.print("Invalid Compartment number");
						}
					}		
					else{
							System.out.print("Please give the valid compartment number, where the theisis is in");
						}
	  				}
	  				else{
	  						System.out.print("Compartments cant be zero please try again"); 
	  				}
	} 
	
	// Returns minimum number of 
    // hops to reach compartment from startingpoint 
    static int minHops(int arr[], int startingpoint, int compartment) 
    { 
        // Base case: when source 
        // and destination are same 
        if (compartment == startingpoint) 
            return 0; 
  
        // When nothing is reachable 
        // from the given source 
        if (arr[startingpoint] == 0) 
            return Integer.MAX_VALUE; 
  
        // Traverse through all the points 
        // reachable from starting compartment.
		
        int min = Integer.MAX_VALUE; 
        for (int i = startingpoint + 1; i <= compartment && i <= startingpoint + arr[startingpoint]; i++) { 
            int hops = minHops(arr, i, compartment); 
            if (hops != Integer.MAX_VALUE && hops + 1 < min) 
                min = hops + 1; 
        } 
        return min; 
    } 
  
	
} 

