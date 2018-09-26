class preLab3{
  public static void main(String[] args) {
    System.out.println(digitSum(1231423412));
  }
  public static int digitSum (int i){
    if(i<10) return i;
    return (i%10 + digitSum(i/10));
  }
}
