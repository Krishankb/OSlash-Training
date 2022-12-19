// Simple calculator function to produce the math operation

public class Calculator{

  public int add(int a,int b) {
    int res;
    res = a + b;
    return res;
  }

  public int subtract(int a,int b) {
      int res;
      res = a - b;
      return res;
    }

  public int multiply(int a,int b) {
    int res;
    res = a*b;
    return res;
  }

  public int divide(int a, int b) {
    int res;
    res = a/b;
    return res;
  }

  public int modulo(int a,int b) {
    int res;
    res = a % b;
    return res;
  }

  public static void main(String[] args) {
    Calculator myCalculator = new Calculator();
    int addres,subres;
    addres = myCalculator.add(5,7);
    subres = myCalculator.subtract(45,11);
    System.out.println(addres);
    System.out.println(subres);
    

  }
  

}

