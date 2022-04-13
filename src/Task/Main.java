package Task;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialise scanner variable to accept user input
        Scanner scanner = new Scanner(System.in);

        //Initialise variables to store the input numbers
        int varA;
        int varX;

        //Start while loop so that when a task has been finished, the application will re-start
	    while (true){

	        //Ask for the first number
	        System.out.print("Please enter a number: ");

	        //Catch NFE to ensure that only valid integers are entered when parsing
	        try{

	            //Store the first entered number in varA
	            varA = Integer.parseInt(scanner.next());

	            //Ask for the second number
	            System.out.print("Please enter another number: ");
	            //Store the second entered number in varX
	            varX = Integer.parseInt(scanner.next());

	            //Check if varA is less than 2 or varX is less than 1
	            if(varA < 2 || varX < 1){

	                //If varA less than 2, tell the user
	                if(varA < 2) System.out.println("\nThe first number must be greater than 1!");
	                //If varX less than 1, tell the user
	                if(varX < 1) System.out.println("The second number must be greater than or equal to 1!");

	                //If varA is greater than or eq to varX
                } else if(varA >= varX){
	                //Tell the user that the first num must be smaller than the second one
                    System.out.println("The first number must be smaller than the second number!\n");

                } else {
	                //Run the task, provide varA and varX
                    new Main().runTask(varA, varX);
                }

	            //Handle the NFE
            }catch (NumberFormatException ex){
	            System.out.println("You must enter a valid integer!\n");
            }

        }
    }

    private void runTask(int a, int x){
        //Init var to control the while loop
        boolean running = true;
        //Init var to store the current multiplier i.e 3X
        int currentMultiplier = 1;
        //Init fresh state for varA after the current goal has been met
        int stateA = a;

        //Init var to store the total number of steps taken to complete the tasks
        int totalSteps = 0;

        //Create a decimal format so the displayed numbers will be easier to read
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern("#,###");

        //Output the starting task, this will show that A needs to get to X
        System.out.println("\nStarting task: " + decimalFormat.format(a) + " (A) -> " + decimalFormat.format(x) + " (X)");

        //Start the while loop, controlled by the previously initialised running var
        while (running){

            //Check that A is less than X and that A is less than 2.1B
            if(a < (x * currentMultiplier) && a < Integer.MAX_VALUE){

                /*This part is an essential fail safe.
                This ensures that A doesn't exceed 2.1b, if this was not here, A would default to 0 and the loop would be infinitely running. */

                //Declare a long variable equal to A * A, the reason a long is used is so that the 2.1B limit can be bypassed and the number can be safely checked
                long safeA = (long) a * a;
                //If the long value is greater than or eq to 2.1B then set A equal to 2.1B
                //Otherwise, continue as usual
                if(safeA >= Integer.MAX_VALUE){
                    //Output the multiplication result but set the result equal to 2.1B
                    System.out.println(decimalFormat.format(a) + " * " + decimalFormat.format(a) + " = " + decimalFormat.format(Integer.MAX_VALUE));
                    a = Integer.MAX_VALUE;
                } else {
                    //Output the multiplication result
                    System.out.println(decimalFormat.format(a) + " * " + decimalFormat.format(a) + " = " + decimalFormat.format(a * a));
                    //Set A equal to A * A
                    a = a * a;
                }

                //Increase the total number of steps taken
                totalSteps++;

            } else{

                //If the currentMultiplier is less than 3 i.e 3X
                if(currentMultiplier < 3){
                    //Increment stateA var by 1
                    stateA++;
                    //Set A equal to stateA
                    a = stateA;

                    //Increment currentMultiplier by 1
                    currentMultiplier++;
                    //Output the next required task
                    System.out.println("\nNew task: " + decimalFormat.format(a) + " (A) -> " + decimalFormat.format(x * currentMultiplier) + " (" + currentMultiplier + "X)");
                } else {
                    //End the while loop (setting controlling var equal to termination value)
                    running = false;
                    //Output the total number of steps taken
                    System.out.println("\nThe total number of steps taken is " +  totalSteps + "\n");
                }
            }
        }
    }
}
