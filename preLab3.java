class preLab3{
  //need first element in args to be the target number
  public static void main(String[] args) {
    System.out.println("digit sum" +digitSum( 1231423412));
    int target = Integer.parseInt(args[0]);
    int [] setOfNums = new int []{3,7,8,15};
    System.out.println("values in the array: ");
    for (int i: setOfNums){
      System.out.print(i + "| ");
    }
    System.out.println();
    System.out.println("can make sum " + target + "? " + canMakeSum(setOfNums, target));
  }
  public static int digitSum (int i){
    if(i<10) return i;
    return (i%10 + digitSum(i/10));
  }
  //my version of canMakeSum prior to Bill's lecture:
  //   public static boolean canMakeSum(int [] setOfNums, int targetSum){
  //     int tempsum = 0;
  //     for(int i: setOfNums){
  //       tempsum+=i;
  //       System.out.println("tempsum: " + tempsum);
  //       if(tempsum == targetSum){
  //         return true;
  //       }
  //     }
  //     if(setOfNums.length ==1){
  //       return false;
  //     }
  //     //run on new array without the first element
  //     //make the new array
  //     int [] setOfLessNums = new int[setOfNums.length-1];
  //     for(int i = 1; i<setOfNums.length; i++){
  //       setOfNums[i-1] = setOfNums[i];
  //     }
  //     return canMakeSum(setOfLessNums, targetSum);
  //   }
  // }

}
