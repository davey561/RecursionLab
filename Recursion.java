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
  // public static void substringHelper(StringBuilder str, int soFar) {
  //   //System.out.println("string in helper: " + str);
  //   if (soFar==str.length()){
  //     if(!str.toString().equals("")){
  //       System.out.println(str.toString());
  //     }
  //   }
  //   //else if there are still letters remaining in the array
  //   else if(soFar<str.length()){
  //     //keep letter at soFar, now consider next letter
  //     substringHelper(str, soFar+1);
  //     //remover letter at index soFar, now consider next letter
  //     substringHelper(str.deleteCharAt(soFar), soFar);
  //   }
  // }

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
    int target = 21;
    int [] setOfNums = new int []{3,7,8,15};
    System.out.println("can make sum " + target + "? " + canMakeSum(setOfNums, target));
    System.out.println(countCannonballs(3));
    System.out.println(countCannonballs(10));

    System.out.println("Expect true, false, true: ");
    System.out.println(isPalindrome("mom"));
    System.out.println(isPalindrome("deeded"));
    System.out.println(isPalindrome("ablewasIereIsawelba"));

    System.out.println("Expect true, true, false");
    System.out.println(isBalanced("[{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}][{[()()]}]"));
    System.out.println(isBalanced("[{[()()]}{]{[()()]}]"));

    System.out.println("Expect abc, ab, bc, ac, a, b, c");
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
