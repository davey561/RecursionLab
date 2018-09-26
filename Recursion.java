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
      //System.out.println("in subsetSumHelper with first value in array " + arr[index] + " and target "+ target);
      //If the target is equal to the first item in the array, we can indeed make the sum, return true;
      if(arr[index] == target){
        //System.out.println(arr[index] + " equals " + target);
        return true;
      }
      //then, check possibilites that include three
      if(subsetSumHelper(arr, target-arr[index], index+1)){
        //System.out.println("possibilities that include " + arr[index]);
        return true;
      }

      //check possibilites that don't include three
      if(subsetSumHelper(arr, target, index+1)) {
        //System.out.println("possibilities that include " + arr[index]);
        return true;
      }
      //if no possibilities include three, return false
      return false;
    }
    return false;
  }

  /*****  1  ***************************************************/

  /*
  * Return number of cannoballs in pyramid with the given `height`.
  * pre:
  * post:
  * Big-O runtime:
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
  public static boolean isBalanced(String str) {
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
    System.out.println(str);
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
  public static void substringHelper(String str, String soFar) {

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
    System.out.println(0);
  }


  /*****  6  ***************************************************/


  /*
  * Return whether a subset of the numbers in nums add up to sum,
  * and print them out.
  *
  * pre:
  * post:
  * Big-O runtime:
  */
  public static boolean printSubSetSum(int nums[], int targetSum) {
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
    return 0;
  }


  /**************************************************************/

  /*
  * Add testing code to main to demonstrate that each of your
  * recursive methods works properly.
  */
  public static void main(String args[]) {

    // Please add your own tests to supplement these
    // Not all cases are thoroughly checked!!!

    System.out.println(countCannonballs(3));
    System.out.println(countCannonballs(10));

    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

    System.out.println(isBalanced("[{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));

    substrings("abc");
    System.out.println();
    substrings("CSCI136");
    System.out.println();
    substrings("a");
    System.out.println();
    substrings("");
    System.out.println();

    printInBinary(0);
    System.out.println();
    printInBinary(30);
    System.out.println();
    printInBinary(1);
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

    System.out.println(printSubSetSum(numSet, 21));
    System.out.println(printSubSetSum(numSet, 22));
    System.out.println(printSubSetSum(numSet, 3));
    System.out.println(printSubSetSum(numSet, 30));

    System.out.println(countSubSetSumSolutions(numSet, 21));
    System.out.println(countSubSetSumSolutions(numSet, 22));
    System.out.println(countSubSetSumSolutions(numSet, 3));
    System.out.println(countSubSetSumSolutions(numSet, 30));

  }
}
