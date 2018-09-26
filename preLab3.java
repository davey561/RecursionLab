class preLab3{
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
  public static boolean canMakeSum(int [] arr, int target){
      return subsetSumHelper(arr, target, 0);
  }
  public static boolean subsetSumHelper(int [] arr, int target, int index){
    //if haven't run out of remaining integeres in array yet
    if(index<arr.length){
      System.out.println("in subsetSumHelper with first value in array " + arr[index] + " and target "+ target);
      //If the target is equal to the first item in the array, we can indeed make the sum, return true;
      if(arr[index] == target){
        System.out.println(arr[index] + " equals " + target);
        return true;
      }
      //then, check possibilites that include three
      if(subsetSumHelper(arr, target-arr[index], index+1)){
        System.out.println("possibilities that include " + arr[index]);
        return true;
      }

      //check possibilites that don't include three
      if(subsetSumHelper(arr, target, index+1)) {
        System.out.println("possibilities that include " + arr[index]);
        return true;
      }
      //if no possibilities include three, return false
      return false;
    }
    return false;
  }
}
