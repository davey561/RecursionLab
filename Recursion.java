/*
* Recursion.java
*
* Starter code for the recursion lab.
*
*/
import structure5.*;

public class Recursion {

  /***** Warmup 0.2 ********************************************/
  /*
  * Return true if `str` is a palindrome.
  * pre: arr cannot have null values, target must be nonnegative
  * post:
  * Big-O runtime:
  */
  public static boolean canMakeSum(int [] arr, int target){
      return subsetSumHelper(arr, target, 0);
  }
  //helper method to be called recursively for canMakeSum
  public static boolean subsetSumHelper(int [] arr, int target, int index){
    //if haven't run out of remaining integeres in array yet
    if(index<arr.length){
      //If the target is equal to the first item in the array, we can indeed make the sum, return true;
      if(arr[index] == target) return true;
      //Then, check possibilites that include arr[index]
      if(subsetSumHelper(arr, target-arr[index], index+1)) return true;
      //Check possibilites that don't include three
      if(subsetSumHelper(arr, target, index+1)) return true;
      //If no possibilities include arr[index], return false
    }
    //then, given that no subsets sum to target:
    return false;
  }

  /*****  1  ***************************************************/

  /*
  * Return number of cannoballs in pyramid with the given `height`.
  * pre: height needs to be 1 or greater
  * post: will return a positive integer
  * Big-O runtime: ~height
  */
  public static int countCannonballs(int height) {
    if(height == 1) return 1;
    return ((int)Math.pow(height, 2) + countCannonballs(height-1));
  }


  /*****  2  ***************************************************/

  /*
  * Return true if `str` is a palindrome.
  * pre:
  * post:
  * Big-O runtime:
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
  * pre:
  * post:
  * Big-O runtime:
  */
  static String [] bracketTypes = new String []{"()","{}","[]"};
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
  * pre:
  * post:
  * Big-O runtime:
  */
  public static void substrings(String str) {
    substringHelper(str, "");
  }

  /*
  * Helper method for substrings(String str)
  * `soFar` keeps track of the characters currently in the substring
  *   being built
  *
  * pre:
  * post:
  * Big-O runtime:
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
      //keep letter at soFar, now consider next letter
      substringHelper(str.substring(1, str.length()), soFar + str.substring(0,1));
      //remover letter at index soFar, now consider next letter
      substringHelper(str.substring(1, str.length()), soFar);
    }
  }

  /*****  5  ***************************************************/

  /*
  * Print `number` in binary
  *
  * pre:
  * post:
  * Big-O runtime:
  */
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
  * pre:
  * post:
  * Big-O runtime:
  */
  public static boolean printSubSetSum(int nums[], int targetSum) {
    return printSubSetSumHelper(nums, targetSum, 0);
  }
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
  * pre:
  * post:
  * Big-O runtime:
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
        return 1;
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
  * pre:
  * post:
  * Big-O runtime:
  */
  public static void printSubSetSums(int nums[], int targetSum) {
    printSubSetSumsHelper(nums, targetSum, 0, "");
  }
  //helper method to be called recursively for printSubSetSum
  public static boolean printSubSetSumsHelper(int [] nums, int targetSum, int index, String soFar){
    //if haven't run out of remaining integers in array yet
    if(index<nums.length){
      //If the target is equal to the first item in the array, we can indeed make the sum, return true;
      if(nums[index] == targetSum) {
        System.out.println("number being considered, " + nums[index] + ", is target sum.");
        System.out.print(soFar + nums[index] + "|     ");
        if(index!=0)return true;
      }
      //Then, check possibilites that include arr[index]
      if(printSubSetSumsHelper(nums, targetSum-nums[index], index+1, soFar +  (nums[index] + "| "))){
        //System.out.print(nums[index] + "| testing possibilities with this num"/*+"(testing poss's with this num) "*/);
        if(index!=0)return true;
      }
      //Check possibilites that don't include three
      if(printSubSetSumsHelper(nums, targetSum, index+1, soFar)){
        //System.out.println("now considering possibilities withOUT " + nums[index]);
        if(index!=0)return true;
      }
      //If no possibilities include arr[index], return false
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

    // Please add your own tests to supplement these
    // Not all cases are thoroughly checked!!!
    int target = 21;
    int [] setOfNums = new int []{3,7,8,15};
    //System.out.println("can make sum " + target + "? " + canMakeSum(setOfNums, target));
    System.out.println(countCannonballs(3));
    System.out.println(countCannonballs(10));

    System.out.println("CanMakeSum: expect: true, false, true: ");
    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

    System.out.println("CanMakeSum: expect: true, true, false");
    System.out.println(isBalanced("[{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));

    System.out.println("CanMakeSum: expect: abc, ab, bc, ac, a, b, c");
    substrings("abc");
    System.out.println();
    substrings("CSCI136");
    System.out.println();
    substrings("a");
    System.out.println();
    substrings("");
    System.out.println();

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


    int[] numSet = {2, 5, 7, 12, 16, 21, 30};
    System.out.println(canMakeSum(numSet, 21));
    System.out.println(canMakeSum(numSet, 22));
    System.out.println(canMakeSum(numSet, 3));
    System.out.println(canMakeSum(numSet, 30));

    //System.out.println("Testing printSubSetSum method, with inputs 21, 22, 3, 30:");
    System.out.println(printSubSetSum(numSet, 21));
    System.out.println(printSubSetSum(numSet, 22));
    System.out.println(printSubSetSum(numSet, 3));
    System.out.println(printSubSetSum(numSet, 30));

    System.out.println(countSubSetSumSolutions(numSet, 21));
    System.out.println(countSubSetSumSolutions(numSet, 22));
    System.out.println(countSubSetSumSolutions(numSet, 3));
    System.out.println(countSubSetSumSolutions(numSet, 30));

    printSubSetSums(numSet, 21);
    // printSubSetSums(numSet, 22);
    // printSubSetSums(numSet, 3);
     printSubSetSums(numSet, 30);

  }
}
