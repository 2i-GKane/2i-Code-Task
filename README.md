**Assumptions Made**

 - Values of A and X are not static and requires user input
 - A and X are positive whole numbers, meaning that the integer data type is used
 - The value of A should be less than the value of X
 - The value of A should be higher than 1
 - Outputs are made to the user at each stage of the calculations
 - It's possible that invalid inputs are provided, this requires there to be validation in place
 
 **Implementation Overview**
 
The application will ask the user to enter two numbers. These two numbers are then checked to ensure that they're valid integers, that A's value is greater than 1, that X's value is greater than 0, and A is less than X. A loop is then started, inside this loop there will be a check, this check will check whether the value of A less than X. If A's value is less than X and less than 2.1B, the calculations can be carried out. Since the integer data type is in-play, an additional check will be made to ensure that the calculated value is not greater than the 2.1B integer limit.
 
The reason that this check is required is that if the integer's value exceeds 2.1B then the while loop will never end due to the nature of the criteria. To perform this check, the calculated value must be stored as a long data type. Storing as a long allows the 2.1B limit to be bypassed, if the calculated value (A * A) is greater than 2.1B then the value of A is set to 2.1B. The calculated value is then output and the total number of steps taken is increased by 1. Once the value of A is greater than or equal to the current multiplication of X (2X/3X) or A's value is integer limit, a check is done to see if X's multiplier is less than 3.

If X's multiplier is less than 3, X's multiplier and A are increased by 1 and new task is then output (new values of A and X), the calculations are then re-ran with the new parameters. Otherwise, the total number of steps taken is output and the application is re-ran.

**Activity Diagram**


![Activity Diagram](https://i.imgur.com/aLhRKJb.png)
