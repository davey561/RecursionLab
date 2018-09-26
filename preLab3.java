class preLab3{
  public static void main(String[] args) {
    System.out.println("digit sum" +digitSum( 1231423412));
    System.out.println("can make sum? " + canMakeSum(new int []{3,4,5}, 9));
  }
  public static int digitSum (int i){
    if(i<10) return i;
    return (i%10 + digitSum(i/10));
  }
  public static boolean canMakeSum(int [] setOfNums, int targetSum){
    int tempsum = 0;
    for(int i: setOfNums){
      tempsum+=i;
      System.out.println("tempsum: " + tempsum);
      if(tempsum == targetSum){
        return true;
      }
    }
    if(setOfNums.length ==1){
      return false;
    }
    //run on new array without the first element
    //make the new array
    int [] setOfLessNums = new int[setOfNums.length-1];
    for(int i = 1; i<setOfNums.length; i++){
      setOfNums[i-1] = setOfNums[i];
    }
    return canMakeSum(setOfLessNums, targetSum);
  }
}
