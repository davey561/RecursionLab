/*
* Recursion.java
*
* Starter code for the recursion lab.
*
*/
//import structure5.*;

public class Recursion {

  /***** Warmup 0.2 ********************************************/
  /*
  * Return true if can make the target from summing any subset of arr.
  * pre: arr cannot have null values, target must be nonnegative
  * post: whether the sum can be made
  * Big-O runtime: O(2^arr.length) (same as helper method)
  */
  public static boolean canMakeSum(int [] arr, int target){
      return subsetSumHelper(arr, target, 0);
  }
  /*
  * helper method to be called recursively for canMakeSum
  * pre: arr cannot have null values, target must be nonnegative
  * post: whether the sum can be made
  * Big-O runtime: O(2^arr.length)
  */
  public static boolean subsetSumHelper(int [] arr, int target, int index){
    //if program hasn't run out of remaining integers in array yet
    if(index<arr.length){
      //if  target is equal to  first item in arr, sum can be made;
      if(arr[index] == target) return true;
      //Check whether any possibilites that include arr[index] sum to target;
      if(subsetSumHelper(arr, target-arr[index], index+1)) return true;
      //Check whether any possibilites that don't include arr[index] sum to target;
      if(subsetSumHelper(arr, target, index+1)) return true;
    }
    //if here, then no subsets of arr sum to target:
    return false;
  }

  /*****  1  ***************************************************/

  /*
  * Return number of cannoballs in pyramid with the given `height`.
  * pre: height needs to be 1 or greater
  * post: will return a positive integer
  * Big-O runtime: O(height)
  */
  //$ Height of 0 is OK! just return 0: an empty pile has no cannonballs
  public static int countCannonballs(int height) {
    if(height == 1) return 1;
    return ((int)Math.pow(height, 2) + countCannonballs(height-1));
  }


  /*****  2  ***************************************************/

  /*
  * Return true if `str` is a palindrome.
  * pre: str cannot be null
  * post: whether the string is a palindrone (reads the same forwards and backwards)
  * Big-O runtime: O(str.length())
  */
  /*$
    Although you make O(n) calls, each call has a linear operation
    that takes O(n) time (substring). Thus, the total runtime is O(n^2)
  */
  public static boolean isPalindrome(String str) {
    if(str.equals(""))
      return true;
    if(str.length()==1)
      return true;
    if(str.charAt(0)==str.charAt(str.length()-1)){
      return isPalindrome(str.substring(1, str.length()-1));
    }

    return false;
  }

  /*****  3  ***************************************************/

  /*
  * Return true if `str` is a string of matched parens,
  * brackets, and braces.
  *
  * pre: str must be an expression only consisting of closed or open parentheses, brackets, or braces
  * post: will whether the braces in the string are all matching
  * Big-O runtime: O(str.length()^2)
  */
  static String [] bracketTypes = new String []{"()","{}","[]"};
  //$ clever!
  public static boolean isBalanced(String str) {
    if(str.equals("")) return true;
    for(String brack: bracketTypes){
      if(str.indexOf(brack)!=-1){
        return isBalanced(str.replace(brack, ""));
      }
    }
    return false;
  }

  /*****  4  ***************************************************/

  /*
  * Print all substrings of `str`.  (Order does not matter.)
  *
  * pre: str must be a non-null
  * post: will print out all of the substrings of that string
  * Big-O runtime: 2^str.length() (same as substringHelper's runtime)
  */
  public static void substrings(String str) {
    substringHelper(str, "");
  }

  /*
  * Helper method for substrings(String str)
  * `soFar` keeps track of the characters currently in the substring
  *   being built
  *
  * pre: str must be a non-null
  * post: will print out all of the substrings of that string
  * Big-O runtime: O(2^str.length())
  */

  //As it is written currently, this method prints out every combination of particular letters,
  //treating letters as distinct if they show up in different places in the string input (regardless of whether they are actually distinct letters)
  public static void substringHelper(String str, String soFar) {
    //System.out.println("string in helper: " + str);
    if (str.length()==0){
        System.out.println(soFar);
    }
    //else if there are still letters remaining in the array
    else if(str.length()>0){
      //move letter from str to soFar, now consider next letter
      substringHelper(str.substring(1, str.length()), soFar + str.substring(0,1));
      //remove first letter at from str, now consider next letter
      substringHelper(str.substring(1, str.length()), soFar);
    }
  }

  /*****  5  ***************************************************/

  /*
  * Print `number` in binary
  *
  * pre: number must be a nonnegative integer
  * post: will print out its binary representation
  * Big-O runtime: O(log base ten of number, i.e. the number's number of digits)
  */
  //$ It's actually the number of binary digits, so O(log_2(n)) instead of
  //$ log base 10
  public static void printInBinary(int number) {
    // String binaryRep = "";
    // if(number == 0 || number == 1){
    //   binaryRep += number;
    // }
    // else{
    //   binaryRep += printInBinary
    // }
    // System.out.println(0);

    if(number == 0 || number ==1){
      System.out.print(number);
    }
    else{
      printInBinary(number/2);
      System.out.print(number%2);
    }
  }


  /*****  6  ***************************************************/


  /*
  * Return whether a subset of the numbers in nums add up to sum,
  * and print them out. FOR A FUNCTION THAT PRINTS ALL SUBSETS, SEE "printSubSetSums" (PLURAL)
  *
  * pre: nums needs to be full array of integer (ie no null elements), target sum a nonnegative integer
  * post: prints all subsets that sum to targetSum
  * Big-O runtime: O(2^nums.length)
  */
  public static boolean printSubSetSum(int nums[], int targetSum) {
    return printSubSetSumHelper(nums, targetSum, 0);
  }
  /*
  * Helper method for printSubSetSum
  * FOR A FUNCTION THAT PRINTS ALL SUBSETS, SEE "printSubSetSums" (PLURAL)
  *
  * pre: nums needs to be full array of integer (ie no null elements), targetSum and index>=0
  * post: prints all possible subsets of the subset of nums that is without the elements with indices less than 'index'
  * Big-O runtime: O(2^nums.length)
  */
  //helper method to be called recursively for printSubSetSum
  public static boolean printSubSetSumHelper(int [] nums, int targetSum, int index){
    //if haven't run out of remaining integers in array yet
    if(index<nums.length){
      //If the target is equal to the first item in the array, we can indeed make the sum, return true;
      if(nums[index] == targetSum) {
      //  System.out.println("number being considered, " + nums[index] + ", is target sum.");
        System.out.print(nums[index] + "| ");
        return true;
      }
      //Then, check possibilites that include arr[index]
      if(printSubSetSumHelper(nums, targetSum-nums[index], index+1)){
        System.out.print(nums[index] + "| "/*+"(testing poss's with this num) "*/);
        return true;
      }
      //Check possibilites that don't include three
      if(printSubSetSumHelper(nums, targetSum, index+1)){
        //System.out.println("now considering possibilities withOUT " + nums[index]);
        return true;
      }
      //If no possibilities include arr[index], return false
    }
    //then, given that no subsets sum to target:
    return false;
  }


  /*
  * Return the number of different ways elements in nums can be
  * added together to equal sum (you do not need to print them all).
  *
  * pre: nums needs to be full array of integer (ie no null elements), targetSum>=0
  * post: the number of subsets in the given nums set whose sum is the target
  * Big-O runtime: O(2^nums.length)
  */
  public static int countSubSetSumSolutions(int nums[], int targetSum) {
    return countSubSetSumHelper(nums, targetSum, 0);
  }
  //helper method to be called recursively for printSubSetSum
  public static int countSubSetSumHelper(int [] nums, int targetSum, int index){
    //if haven't run out of remaining integers in array yet
    if(index<nums.length){
      //If the target is equal to the first item in the array, we can indeed make the sum, return true;
      if(nums[index] == targetSum) {
      //  System.out.println("number being considered, " + nums[index] + ", is target sum.");
      //  System.out.print(nums[index] + "| ");
        return 1 + (countSubSetSumHelper(nums, targetSum-nums[index], index+1)
                + countSubSetSumHelper(nums, targetSum, index+1));
      }
      else{
        return (countSubSetSumHelper(nums, targetSum-nums[index], index+1)
                + countSubSetSumHelper(nums, targetSum, index+1));
      }
    }
    //then, given that no subsets sum to target:
    return 0;
  }

  /*
  * Prints out ALL sets of numbers in nums that add up to sum.
  *
  * pre: nums needs to be full array of integer (ie no null elements), targetSum>=0
  * post: prints each of the subsets in the given nums set whose sum is the target
  * Big-O runtime: O(2^nums.length()) (same as printSubSetSumsHelper)
  */
  public static void printSubSetSums(int nums[], int targetSum) {
    printSubSetSumsHelper(nums, targetSum, 0, "");
  }

  /*
  *helper method to be called recursively for printSubSetSums
  *
  * pre: nums needs to be full array of integer (ie no null elements), targetSum>=0
  * post: prints each of the subsets of the subset of nums that is without the elememts with indices less than 'index' whose sum is the target
  * Big-O runtime:  O(2^nums.length())
  */
  public static boolean printSubSetSumsHelper(int [] nums, int targetSum, int index, String soFar){
    //if haven't run out of remaining integers in array yet
    boolean brady = false;
    if(index<nums.length){
      //If the target is equal to the first item in the array, we can indeed make the sum, return true;
      //System.out.println(index + ": looking at " + nums[index] + ". " + "targetSum is " + targetSum);
      if(nums[index] == targetSum) {
        //if(targetSum == 21){System.out.println("it's 21 szn!!!!");}
        System.out.println(soFar + nums[index]);
        if(index!=0)brady = true;
      }
      //Then, check possibilites that include arr[index]
      //System.out.println(index + ": considering possibilities with " + nums[index] + ". ");
      if(printSubSetSumsHelper(nums, targetSum-nums[index], index+1, soFar +  (nums[index] + ", "))){
        if(index!=0)brady= true;
      }
      //Check possibilites that don't include three
      //System.out.println(index + ": now considering possibilities without " + nums[index] + ". ");
      if(printSubSetSumsHelper(nums, targetSum, index+1, soFar)){
        if(index!=0)brady= true;
      }

      return brady;
    }
    //then, given that no subsets sum to target:
    return false;
  }


  /**************************************************************/

  /*
  * Add testing code to main to demonstrate that each of your
  * recursive methods works properly.
  */
  public static void main(String args[]) {

    System.out.println("\nCANNON BALL");
    System.out.println("cannon ball pyramid with height 3: " + countCannonballs(3));
    System.out.println("cannon ball pyramid with height 10: " + countCannonballs(10));

    System.out.println("\nIS PALINDRONE. Expect: true, false, true: ");
    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

    System.out.println("\nIS BALANCED. Expect: true, true, false");
    System.out.println(isBalanced("[{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));

    System.out.println("\nSUBSTRING: abc, CSCI136, a, [blank]");
    substrings("abc");
    System.out.println();
    substrings("CSCI136");
    System.out.println();
    substrings("a");
    System.out.println();
    substrings("");
    System.out.println();


    System.out.println("\nPRINT IN BINARY: 0, 30, 1, 110, 2048, 43");
    printInBinary(0); //expect 0
    System.out.println();
    printInBinary(30); //expect 11110
    System.out.println();
    printInBinary(1); //expect 1
    System.out.println();
    printInBinary(110);
    System.out.println();
    printInBinary(2048);
    System.out.println();
    printInBinary(43);
    System.out.println();

    System.out.println("CAN MAKE SUM? {2, 5, 7, 12, 16, 21}. 21, 22, 3, 30");
    int[] numSet = {2, 5, 7, 12, 16, 21};
    System.out.println(canMakeSum(numSet, 21));
    System.out.println(canMakeSum(numSet, 22));
    System.out.println(canMakeSum(numSet, 3));
    System.out.println(canMakeSum(numSet, 30));

    System.out.println("PRINT SUBSET SUM. {2, 5, 7, 12, 16, 21}. 21, 22, 3, 30");
    //System.out.println("Testing printSubSetSum method, with inputs 21, 22, 3, 30:");
    System.out.println(printSubSetSum(numSet, 21));
    System.out.println(printSubSetSum(numSet, 22));
    System.out.println(printSubSetSum(numSet, 3));
    System.out.println(printSubSetSum(numSet, 30));

    System.out.println("COUNT SUBSET SUM SOLUTIONS. {2, 5, 7, 12, 16, 21}. 21, 22, 3, 30");
    System.out.println(countSubSetSumSolutions(numSet, 21));
    System.out.println(countSubSetSumSolutions(numSet, 22));
    System.out.println(countSubSetSumSolutions(numSet, 3));
    System.out.println(countSubSetSumSolutions(numSet, 30));
    System.out.println("now with new set {-1,1,0}, get to 0: " +countSubSetSumSolutions(new int[] {-1,1,0}, 0));

    System.out.println("PRINT SUBSET SUMSSSS: {2, 5, 7, 12, 16, 21}. 21, 22, 2, 30");
    printSubSetSums(numSet, 21);
    System.out.println();
    printSubSetSums(numSet, 22);
    System.out.println();
    printSubSetSums(numSet, 3);
    System.out.println();
    printSubSetSums(numSet, 30);
    System.out.println();
    printSubSetSums(new int[] {-1,1,0}, 0);
    System.out.println("now with different set of nums: 2, 4, 3, 7. get to 7");
    printSubSetSums(new int []{2,4,3,7}, 7);

  }
}
